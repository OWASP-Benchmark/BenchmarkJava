#!/usr/bin/env bash

# This script will
# - start the Benchmark web app via ./runRemoteAccessibleBenchmark.sh (https://localhost:8443/benchmark/)
# - start a temporary OWASP ZAP daemon in docker
# - discover the test cases (traditional spider, optionally AJAX spider and/or the Benchmark crawler)
# - active scan them with the scan rules that map to the CWEs the Benchmark expects a DAST tool to find
# - write a traditional-JSON report into results/
# - shut the ZAP container and the Benchmark web app back down (ZAP stays up with --keep-zap)
#
# Check for install/updates at https://github.com/zaproxy/zaproxy
#
# Only ~1639 of the 2740 test cases are DAST-detectable at all. The remaining ones
# (weakrand/crypto/hash/trustbound) are internal code properties with no observable
# signal over HTTP, so no DAST tool can score them. See coverage summary at the end.

source scripts/requireCommand.sh

requireCommand curl
requireCommand docker
requireCommand jq
requireCommand mvn

zap_image="zaproxy/zap-weekly"
zap_container="zap-benchmark"

# ZAP runs in a container, so localhost:8443 would be the *container's* loopback.
# host.docker.internal resolves to the docker host instead. The scorecard keys off the
# BenchmarkTestNNNNN part of the URI, so the non-localhost hostname in the report is fine.
benchmark_host="host.docker.internal"
benchmark_port="8443"
benchmark_local_url="https://localhost:$benchmark_port/benchmark/"
benchmark_target_url="https://$benchmark_host:$benchmark_port/benchmark/"

# Hard scope lock. Every Benchmark page links to https://fonts.googleapis.com/... -
# without this ZAP would happily spider and attack Google's CDN.
context_name="Benchmark"
context_regex="https://$benchmark_host:$benchmark_port/benchmark/.*"

# CWEs the Benchmark expects from a DAST tool and that ZAP has scan rules for:
# 22 pathtraver, 78 cmdi, 79 xss, 89 sqli, 90 ldapi, 614 securecookie, 643 xpathi
target_cwes="22 78 79 89 90 614 643"

results_dir="results"
crawler_file="data/benchmark-crawler-http.xml"
zap_crawler_file="target/benchmark-crawler-zap.xml"

# ZAP's target parameter bitmask (ScannerParam): query string 1 + POST data 2 +
# HTTP headers 4 + cookie data 8 + URL path 32. Headers and cookies are off by
# default; without them the 657 header and 216 cookie test cases can never be hit.
injectable_params="47"

usage() {
  cat <<USAGE_EOF
Usage: ./scripts/runZAP.sh [--depth=LEVEL] [--discovery=MODE] [--debug] [--keep-zap]

  --depth=LEVEL       quick | standard | full | insane   (default: full)
                        quick     attack strength Low,    active scan capped at 30m, ajax 10m
                        standard  attack strength Medium, active scan capped at 4h,  ajax 30m
                        full      attack strength High,   active scan capped at 12h, ajax 60m
                        insane    attack strength Insane, active scan uncapped,      ajax 120m
  --discovery=MODE    spider | spider+ajax | spider+crawler   (default: spider+ajax)
                        spider          traditional spider only; misses the 657 header test cases
                        spider+ajax     also runs the AJAX spider (headless browser)
                        spider+crawler  also replays data/benchmark-crawler-http.xml through ZAP
  --debug             additionally keep the HTML report, the ZAP session file, the ZAP
                      daemon log and the Benchmark server log under target/zap-run-<timestamp>/
  --keep-zap          leave the ZAP container running after a successful scan, so its UI and
                      API (e.g. /OTHER/core/other/xmlreport/) stay reachable on localhost;
                      prints the URL, the API key and the command to remove the container

Both flags skip their prompt, so a run that had to be abandoned can be relaunched
with an identical configuration.
USAGE_EOF
}

depth=""
discovery=""
debug="false"
keep_zap="false"

for arg in "$@"; do
  case "$arg" in
    --depth=*)     depth="${arg#*=}" ;;
    --discovery=*) discovery="${arg#*=}" ;;
    --debug)       debug="true" ;;
    --keep-zap)    keep_zap="true" ;;
    -h|--help)     usage; exit 0 ;;
    *)             echo "Unknown option: $arg"; echo ""; usage; exit 1 ;;
  esac
done

if [ ! -f "runRemoteAccessibleBenchmark.sh" ]; then
  echo "This script has to be run from the Benchmark root directory: ./scripts/runZAP.sh"
  exit 1
fi

# --- resolve configuration -------------------------------------------------

if [ -z "$depth" ]; then
  echo "How deep should ZAP scan?"
  echo "  1) quick     - attack strength Low,    active scan capped at 30m"
  echo "  2) standard  - attack strength Medium, active scan capped at 4h"
  echo "  3) full      - attack strength High,   active scan capped at 12h  (default)"
  echo "  4) insane    - attack strength Insane, active scan uncapped"
  read -r -p "Depth [3]: " answer
  case "${answer:-3}" in
    1|quick)    depth="quick" ;;
    2|standard) depth="standard" ;;
    3|full)     depth="full" ;;
    4|insane)   depth="insane" ;;
    *)          echo "Invalid selection: $answer"; exit 1 ;;
  esac
  echo ""
fi

case "$depth" in
  quick)    attack_strength="LOW";    alert_threshold="MEDIUM"; ascan_max_mins=30;  ajax_max_mins=10 ;;
  standard) attack_strength="MEDIUM"; alert_threshold="MEDIUM"; ascan_max_mins=240; ajax_max_mins=30 ;;
  full)     attack_strength="HIGH";   alert_threshold="MEDIUM"; ascan_max_mins=720; ajax_max_mins=60 ;;
  insane)   attack_strength="INSANE"; alert_threshold="LOW";    ascan_max_mins=0;   ajax_max_mins=120 ;;
  *)        echo "Invalid depth: $depth (expected quick, standard, full or insane)"; exit 1 ;;
esac

if [ -z "$discovery" ]; then
  echo "How should ZAP discover the test cases?"
  echo "  1) spider          - traditional spider only; misses the 657 header test cases"
  echo "  2) spider+ajax     - also run the AJAX spider, which exercises the header forms  (default)"
  echo "  3) spider+crawler  - also replay the Benchmark crawler file through the ZAP proxy"
  read -r -p "Discovery [2]: " answer
  case "${answer:-2}" in
    1|spider)         discovery="spider" ;;
    2|spider+ajax)    discovery="spider+ajax" ;;
    3|spider+crawler) discovery="spider+crawler" ;;
    *)                echo "Invalid selection: $answer"; exit 1 ;;
  esac
  echo ""
fi

case "$discovery" in
  spider|spider+ajax|spider+crawler) ;;
  *) echo "Invalid discovery: $discovery (expected spider, spider+ajax or spider+crawler)"; exit 1 ;;
esac

# --- pre-flight checks -----------------------------------------------------

port_in_use() {
  (exec 3<>"/dev/tcp/127.0.0.1/$1") > /dev/null 2>&1
}

if port_in_use "$benchmark_port"; then
  echo "Port $benchmark_port is already in use."
  echo "This script starts and stops its own Benchmark server, so it will not reuse or kill that one."
  echo "Stop whatever is listening on $benchmark_port and try again."
  exit 1
fi

# The crawler replay runs through the benchmarkutils maven plugin, so make sure it is
# installed before spending half an hour building and spidering the web app.
case "$discovery" in
  *crawler*) source "scripts/verifyBenchmarkPluginAvailable.sh" ;;
esac

if [ -n "$(docker ps -aq -f "name=^${zap_container}$")" ]; then
  echo "A docker container named '$zap_container' already exists."
  echo "Remove it with 'docker rm -f $zap_container' and try again."
  exit 1
fi

# ZAP serves its API and its proxy on the same port, so one published port covers both.
# It is bound to 127.0.0.1 and protected with a random API key: a ZAP with attack rules
# loaded should not sit reachable for the next twelve hours.
zap_api_port=""
for candidate in $(seq 8090 8099); do
  if ! port_in_use "$candidate"; then
    zap_api_port="$candidate"
    break
  fi
done

if [ -z "$zap_api_port" ]; then
  echo "Could not find a free port for the ZAP API in the range 8090-8099."
  exit 1
fi

zap_api_key=$(dd if=/dev/urandom bs=1 count=256 2> /dev/null | LC_ALL=C tr -dc 'a-zA-Z0-9' | head -c 32)

if [ -z "$zap_api_key" ]; then
  echo "Could not generate a ZAP API key."
  exit 1
fi

benchmark_version=$(scripts/getBenchmarkVersion.sh 2> /dev/null | grep -E '^[0-9]+\.[0-9]')

if [ -z "$benchmark_version" ]; then
  echo "Could not determine the Benchmark version."
  exit 1
fi

mkdir -p "$results_dir"

# The web app build runs 'mvn clean', which wipes target/ - including anything we put
# there beforehand. So the run directory is created once the app is up, and the server
# log starts outside target/ and is moved in at the end.
run_dir=""
server_log=$(mktemp -t benchmark-server-log)

# --- ZAP API helpers -------------------------------------------------------

# ZAP only answers API calls when the Host header names ZAP itself, otherwise it treats
# the call as a request to proxy. The container port equals the published port, so
# localhost:<port> already qualifies; "Host: zap" is kept as a belt-and-braces default.
zap_api() {
  local path="$1"
  shift
  curl --silent --max-time 300 --header "Host: zap" --get \
    "http://127.0.0.1:$zap_api_port$path" \
    --data-urlencode "apikey=$zap_api_key" "$@"
}

# Same, but abort the run when ZAP reports a problem, so a misconfiguration surfaces
# before the scan rather than as an empty report twelve hours later.
zap_api_checked() {
  local path="$1"
  shift
  local response
  response=$(zap_api "$path" "$@")

  if [ -z "$response" ] || echo "$response" | grep -q '"code"[[:space:]]*:'; then
    echo ""
    echo "ZAP API call failed: $path"
    echo "  response: ${response:-<empty>}"
    exit 1
  fi

  echo "$response"
}

# --- teardown --------------------------------------------------------------

report_written="false"
scan_started="false"
cleanup_done="false"

stop_benchmark_server() {
  if [ -n "$benchmark_pid" ] && kill -0 "$benchmark_pid" 2> /dev/null; then
    pkill -P "$benchmark_pid" 2> /dev/null
    kill "$benchmark_pid" 2> /dev/null
  fi

  # cargo:run starts Tomcat as a separate JVM that does not always go down with maven.
  # Port 8443 was verified free at startup, so anything still on it now belongs to us.
  local waited=0
  while port_in_use "$benchmark_port" && [ "$waited" -lt 30 ]; do
    sleep 2
    waited=$((waited + 2))
  done

  if port_in_use "$benchmark_port" && command -v lsof > /dev/null 2>&1; then
    local leftover
    leftover=$(lsof -nP -iTCP:"$benchmark_port" -sTCP:LISTEN -t 2> /dev/null)
    if [ -n "$leftover" ]; then
      echo "$leftover" | xargs kill 2> /dev/null
      sleep 3
      echo "$leftover" | xargs kill -9 2> /dev/null
    fi
  fi
}

cleanup() {
  if [ "$cleanup_done" = "true" ]; then
    return
  fi
  cleanup_done="true"

  # A run that was cut short is still worth keeping - these scans take hours - but it
  # must not be scored as if it were complete, hence the PARTIAL marker in the name.
  if [ "$scan_started" = "true" ] && [ "$report_written" = "false" ]; then
    echo ""
    echo "Run did not finish - writing a partial report..."
    write_report "PARTIAL"
  fi

  if [ "$keep_zap" = "true" ] && [ "$report_written" = "true" ] \
    && [ -n "$(docker ps -q -f "name=^${zap_container}$")" ]; then
    echo ""
    echo "ZAP is kept running (--keep-zap):"
    echo "  UI/API:     http://localhost:$zap_api_port/"
    echo "  API key:    $zap_api_key"
    echo "  XML report: http://localhost:$zap_api_port/OTHER/core/other/xmlreport/"
    echo "  e.g.        scripts/fetchZAPResults.sh http://localhost:$zap_api_port/OTHER/core/other/xmlreport/ \"\" $zap_api_key"
    echo "  remove it:  docker rm -f $zap_container"
    echo ""
  elif [ -n "$(docker ps -aq -f "name=^${zap_container}$")" ]; then
    if [ "$debug" = "true" ] && [ -n "$run_dir" ]; then
      docker logs "$zap_container" > "$run_dir/zap-daemon.log" 2>&1
      docker cp "$zap_container:/home/zap/.ZAP_D/zap.log" "$run_dir/zap.log" > /dev/null 2>&1
    fi
    echo "Stopping ZAP..."
    docker stop "$zap_container" > /dev/null 2>&1
    docker rm "$zap_container" > /dev/null 2>&1
  fi

  # Only tear down a server this run started; an early exit must not touch 8443.
  if [ -n "$benchmark_pid" ]; then
    echo "Stopping the Benchmark web app..."
    stop_benchmark_server
  fi

  if [ "$debug" = "true" ] && [ -n "$run_dir" ]; then
    cp "$server_log" "$run_dir/benchmark-server.log" 2> /dev/null
    echo "Debug artifacts: $run_dir"
  elif [ -n "$run_dir" ]; then
    rm -rf "$run_dir"
  fi

  rm -f "$server_log"
}

# INT/TERM exit explicitly, otherwise the scan polling loop would simply carry on
# after the trap handler returns.
trap cleanup EXIT
trap 'cleanup; exit 130' INT
trap 'cleanup; exit 143' TERM

# --- report generation -----------------------------------------------------

# $1: optional marker (e.g. PARTIAL) inserted before the elapsed time, mirroring the
# existing Benchmark_1.2-Acunetix-v1.4.1-FULL-194400.xml naming.
write_report() {
  local marker="$1"
  local elapsed=$((SECONDS - scan_start))
  local suffix="$elapsed"

  if [ -n "$marker" ]; then
    suffix="$marker-$elapsed"
  fi

  # Stop everything before reporting. A still running active scan keeps refilling the
  # passive scan queue we are about to wait on, and on an interrupted run the attack
  # traffic should stop now rather than when the report happens to be finished.
  zap_api "/JSON/ascan/action/stopAllScans/" > /dev/null
  zap_api "/JSON/spider/action/stopAllScans/" > /dev/null
  zap_api "/JSON/ajaxSpider/action/stop/" > /dev/null

  # Late passive alerts - securecookie's 67 test cases are passive-only - are still in
  # the queue when the active scan ends. Reporting before it drains loses them.
  local records
  records=$(zap_api "/JSON/pscan/view/recordsToScan/" | jq -r '.recordsToScan // "0"')
  if [ -n "$records" ] && [ "$records" != "0" ]; then
    echo "Waiting for the passive scan queue to drain ($records records)..."
    while [ "$records" != "0" ] && [ -n "$records" ]; do
      printf '.'
      sleep 5
      records=$(zap_api "/JSON/pscan/view/recordsToScan/" | jq -r '.recordsToScan // "0"')
    done
    echo ""
  fi

  local report_name="Benchmark_$benchmark_version-ZAPweekly-$zap_date-$suffix.json"

  docker exec "$zap_container" mkdir -p /zap/wrk > /dev/null 2>&1

  local generated
  generated=$(zap_api "/JSON/reports/action/generate/" \
    --data-urlencode "title=OWASP Benchmark $benchmark_version" \
    --data-urlencode "template=traditional-json" \
    --data-urlencode "reportFileName=$report_name" \
    --data-urlencode "reportDir=/zap/wrk" \
    --data-urlencode "display=false" | jq -r '.generate // empty')

  if [ -z "$generated" ]; then
    echo "ZAP could not generate the report."
    return 1
  fi

  if ! docker cp "$zap_container:$generated" "$results_dir/$report_name" > /dev/null 2>&1; then
    echo "Could not copy the report out of the ZAP container."
    return 1
  fi

  report_written="true"
  echo "Report: $results_dir/$report_name"

  if [ "$debug" = "true" ]; then
    local html_name="${report_name%.json}.html"
    local html_generated
    html_generated=$(zap_api "/JSON/reports/action/generate/" \
      --data-urlencode "title=OWASP Benchmark $benchmark_version" \
      --data-urlencode "template=traditional-html" \
      --data-urlencode "reportFileName=$html_name" \
      --data-urlencode "reportDir=/zap/wrk" \
      --data-urlencode "display=false" | jq -r '.generate // empty')

    if [ -n "$html_generated" ]; then
      docker cp "$zap_container:$html_generated" "$run_dir/$html_name" > /dev/null 2>&1
    fi

    # The session holds every request, response and alert and opens in the ZAP desktop
    # UI, so a suspicious result never needs a twelve hour re-scan to investigate.
    if [ -n "$(zap_api "/JSON/core/action/saveSession/" \
      --data-urlencode "name=/zap/wrk/benchmark-session" \
      --data-urlencode "overwrite=true" | jq -r '.Result // empty')" ]; then
      docker cp "$zap_container:/zap/wrk/benchmark-session.session" "$run_dir/" > /dev/null 2>&1
      docker cp "$zap_container:/zap/wrk/benchmark-session.session.data" "$run_dir/" > /dev/null 2>&1
      docker cp "$zap_container:/zap/wrk/benchmark-session.session.properties" "$run_dir/" > /dev/null 2>&1
      docker cp "$zap_container:/zap/wrk/benchmark-session.session.script" "$run_dir/" > /dev/null 2>&1
    fi
  fi
}

# --- start the Benchmark web app ------------------------------------------

docker pull "$zap_image"

echo ""
echo "Starting the Benchmark web app... (this builds and deploys the war, it takes a while)"

./runRemoteAccessibleBenchmark.sh --quiet > "$server_log" 2>&1 &
benchmark_pid=$!

waited=0
until curl --insecure --silent --output /dev/null --max-time 10 "$benchmark_local_url"; do
  if ! kill -0 "$benchmark_pid" 2> /dev/null; then
    echo ""
    echo "The Benchmark web app exited before it became reachable. Last lines of its output:"
    tail -20 "$server_log"
    exit 1
  fi

  if [ "$waited" -ge 1800 ]; then
    echo ""
    echo "The Benchmark web app did not become reachable within 30 minutes. Last lines of its output:"
    tail -20 "$server_log"
    exit 1
  fi

  printf '.'
  sleep 5
  waited=$((waited + 5))
done

echo ""
echo "Benchmark web app is up at $benchmark_local_url"

# Safe to create now: the build's 'mvn clean' has already run.
run_dir="target/zap-run-$(date +%Y%m%d-%H%M%S)"
mkdir -p "$run_dir"

# --- start ZAP -------------------------------------------------------------

echo "Starting ZAP..."

# --add-host is what makes host.docker.internal resolve on Linux docker engine; it is
# harmless on Docker Desktop, where the name already exists.
# ZAP listens on the same port inside the container as on the host. With differing ports
# a browser's "Host: localhost:<published port>" does not name ZAP itself, so ZAP proxies
# the request to that port inside the container and answers "Connection refused".
docker run --detach --name "$zap_container" \
  --add-host=host.docker.internal:host-gateway \
  --publish "127.0.0.1:$zap_api_port:$zap_api_port" \
  "$zap_image" \
  zap.sh -daemon -host 0.0.0.0 -port "$zap_api_port" \
  -config "api.addrs.addr.name=.*" \
  -config "api.addrs.addr.regex=true" \
  -config "api.key=$zap_api_key" > /dev/null

if [ -z "$(docker ps -q -f "name=^${zap_container}$")" ]; then
  echo "The ZAP container did not start."
  exit 1
fi

echo "Waiting for ZAP to become ready..."

zap_version=""
waited=0
while [ -z "$zap_version" ]; do
  zap_version=$(zap_api "/JSON/core/view/version/" | jq -r '.version // empty')

  if [ -z "$(docker ps -q -f "name=^${zap_container}$")" ]; then
    echo ""
    echo "The ZAP container stopped while starting up."
    docker logs "$zap_container" 2>&1 | tail -20
    exit 1
  fi

  if [ "$waited" -ge 600 ]; then
    echo ""
    echo "ZAP did not become ready within 10 minutes."
    exit 1
  fi

  if [ -z "$zap_version" ]; then
    printf '.'
    sleep 5
    waited=$((waited + 5))
  fi
done

echo ""
echo "ZAP $zap_version is ready."

# The weekly version reads D-YYYY-MM-DD; the result file names use the plain date,
# matching Benchmark_1.2-ZAPweekly-20150824-18000.xml.
zap_date=$(echo "$zap_version" | tr -cd '0-9')

if [ -z "$zap_date" ]; then
  zap_date=$(date +%Y%m%d)
fi

# --- configure ZAP ---------------------------------------------------------

echo "Configuring ZAP..."

zap_api_checked "/JSON/context/action/newContext/" \
  --data-urlencode "contextName=$context_name" > /dev/null

context_id=$(zap_api "/JSON/context/view/context/" \
  --data-urlencode "contextName=$context_name" | jq -r '.context.id // empty')

if [ -z "$context_id" ]; then
  echo "Could not determine the ZAP context id."
  exit 1
fi

zap_api_checked "/JSON/context/action/includeInContext/" \
  --data-urlencode "contextName=$context_name" \
  --data-urlencode "regex=$context_regex" > /dev/null

zap_api_checked "/JSON/context/action/setContextInScope/" \
  --data-urlencode "contextName=$context_name" \
  --data-urlencode "booleanInScope=true" > /dev/null

echo "  scope locked to $context_regex"

# Select the active scan rules by the CWE they declare rather than by rule id: the ids
# drift between weekly builds, the CWE mapping does not.
cwe_filter=""
for cwe in $target_cwes; do
  if [ -n "$cwe_filter" ]; then
    cwe_filter="$cwe_filter or "
  fi
  cwe_filter="$cwe_filter.cweId == \"$cwe\""
done

scanner_ids=$(zap_api "/JSON/ascan/view/scanners/" | jq -r "[.scanners[] | select($cwe_filter) | .id] | join(\",\")")

if [ -z "$scanner_ids" ]; then
  echo "Could not select any active scan rules for CWEs $target_cwes."
  exit 1
fi

zap_api_checked "/JSON/ascan/action/disableAllScanners/" > /dev/null
zap_api_checked "/JSON/ascan/action/enableScanners/" --data-urlencode "ids=$scanner_ids" > /dev/null

scanner_count=0
for scanner_id in $(echo "$scanner_ids" | tr ',' ' '); do
  zap_api "/JSON/ascan/action/setScannerAttackStrength/" \
    --data-urlencode "id=$scanner_id" \
    --data-urlencode "attackStrength=$attack_strength" > /dev/null
  zap_api "/JSON/ascan/action/setScannerAlertThreshold/" \
    --data-urlencode "id=$scanner_id" \
    --data-urlencode "alertThreshold=$alert_threshold" > /dev/null
  scanner_count=$((scanner_count + 1))
done

echo "  $scanner_count active scan rules enabled at strength $attack_strength / threshold $alert_threshold"

# Passive rules cost nothing extra - the traffic already flows - their unmapped alerts
# are ignored by the scorecard, and securecookie is detected by a passive rule only.
zap_api_checked "/JSON/pscan/action/enableAllScanners/" > /dev/null
echo "  all passive scan rules enabled"

zap_api_checked "/JSON/ascan/action/setOptionTargetParamsInjectable/" \
  --data-urlencode "Integer=$injectable_params" > /dev/null
echo "  input vectors: query string, POST data, URL path, HTTP headers, cookie data"

zap_api_checked "/JSON/ascan/action/setOptionMaxScanDurationInMins/" \
  --data-urlencode "Integer=$ascan_max_mins" > /dev/null

# Depth 2 already reaches all 2740 test pages (index -> category page -> test page).
zap_api_checked "/JSON/spider/action/setOptionMaxDepth/" --data-urlencode "Integer=5" > /dev/null
zap_api_checked "/JSON/spider/action/setOptionMaxChildren/" --data-urlencode "Integer=0" > /dev/null

# --- scan ------------------------------------------------------------------

scan_start=$SECONDS
scan_started="true"

echo ""
echo "Spidering $benchmark_target_url ..."

spider_id=$(zap_api_checked "/JSON/spider/action/scan/" \
  --data-urlencode "url=$benchmark_target_url" \
  --data-urlencode "recurse=true" \
  --data-urlencode "contextName=$context_name" \
  --data-urlencode "subtreeOnly=false" | jq -r '.scan // empty')

if [ -z "$spider_id" ]; then
  echo "Could not start the spider."
  exit 1
fi

spider_status="0"
while [ "$spider_status" != "100" ]; do
  sleep 10
  spider_status=$(zap_api "/JSON/spider/view/status/" --data-urlencode "scanId=$spider_id" | jq -r '.status // "0"')
  echo "  spider: $spider_status%"
done

spider_urls=$(zap_api "/JSON/core/view/urls/" --data-urlencode "baseurl=$benchmark_target_url" | jq -r '.urls | length')
echo "Spider found $spider_urls URLs."

case "$discovery" in
  *ajax*)
    echo ""
    echo "Running the AJAX spider (capped at $ajax_max_mins minutes)..."
    echo "  the header test cases are driven by javascript, so only a browser reaches them"

    zap_api_checked "/JSON/ajaxSpider/action/setOptionMaxDuration/" \
      --data-urlencode "Integer=$ajax_max_mins" > /dev/null

    zap_api_checked "/JSON/ajaxSpider/action/scan/" \
      --data-urlencode "url=$benchmark_target_url" \
      --data-urlencode "inScope=true" \
      --data-urlencode "contextName=$context_name" \
      --data-urlencode "subtreeOnly=false" > /dev/null

    ajax_start=$SECONDS
    ajax_status="running"
    while [ "$ajax_status" = "running" ]; do
      sleep 15
      ajax_status=$(zap_api "/JSON/ajaxSpider/view/status/" | jq -r '.status // "stopped"')
      echo "  ajax spider: $ajax_status after $(( (SECONDS - ajax_start) / 60 ))m of ${ajax_max_mins}m"
    done

    # A capped AJAX spider still leaves the traditional spider's full tree in place;
    # the cap only limits how much extra header-vector discovery happens.
    echo "AJAX spider finished."
    ;;
  *crawler*)
    echo ""
    echo "Replaying the Benchmark crawler through ZAP..."

    # The crawler runs on this host but ZAP resolves the request target inside the
    # container, so the stock localhost URLs would all fail. data/ stays untouched.
    sed 's/localhost/'"$benchmark_host"'/g' "$crawler_file" > "$zap_crawler_file"

    mvn org.owasp:benchmarkutils-maven-plugin:run-crawler \
      -DcrawlerFile="$zap_crawler_file" \
      -DproxyHost=127.0.0.1 \
      -DproxyPort="$zap_api_port"
    ;;
esac

echo ""
if [ "$ascan_max_mins" = "0" ]; then
  echo "Active scanning (uncapped)..."
else
  echo "Active scanning (capped at $ascan_max_mins minutes)..."
fi

ascan_id=$(zap_api_checked "/JSON/ascan/action/scan/" \
  --data-urlencode "url=$benchmark_target_url" \
  --data-urlencode "recurse=true" \
  --data-urlencode "inScopeOnly=true" \
  --data-urlencode "contextId=$context_id" | jq -r '.scan // empty')

if [ -z "$ascan_id" ]; then
  echo "Could not start the active scan."
  exit 1
fi

ascan_status="0"
while [ "$ascan_status" != "100" ]; do
  sleep 30
  ascan_status=$(zap_api "/JSON/ascan/view/status/" --data-urlencode "scanId=$ascan_id" | jq -r '.status // "0"')
  echo "  active scan: $ascan_status% after $(( (SECONDS - scan_start) / 60 ))m"
done

echo ""
echo "Active scan finished. Generating the report..."

write_report ""

# --- summary ---------------------------------------------------------------

elapsed=$((SECONDS - scan_start))

echo ""
echo "Scan took $((elapsed / 3600))h $(((elapsed % 3600) / 60))m $((elapsed % 60))s ($elapsed seconds)"
echo "covered 1639/2740 test cases across 7 of 11 CWEs (weakrand/crypto/hash/trustbound not DAST-detectable)"
