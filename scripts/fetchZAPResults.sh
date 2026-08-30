#!/usr/bin/env bash

# Downloads a ZAP XML report from a URL and saves it to the results/ directory.
# After downloading, run createScorecards.sh to generate the scorecard.
#
# Usage: scripts/fetchZAPResults.sh <ZAP_REPORT_URL> [OUTPUT_FILENAME] [API_KEY]
#
# Examples:
#   scripts/fetchZAPResults.sh http://172.17.0.3:8090/OTHER/core/other/xmlreport/
#   scripts/fetchZAPResults.sh http://zap:8090/OTHER/core/other/xmlreport/ my-zap-results.xml
#   scripts/fetchZAPResults.sh http://zap:8090/OTHER/core/other/xmlreport/ "" my-secret-api-key

source scripts/requireCommand.sh

requireCommand curl

if [ $# -eq 0 ]; then
    echo "Usage: $0 <ZAP_REPORT_URL> [OUTPUT_FILENAME] [API_KEY]" >&2
    echo "" >&2
    echo "Downloads a ZAP XML report from the given URL and saves it to results/." >&2
    echo "After downloading, run createScorecards.sh to generate the scorecard." >&2
    echo "" >&2
    echo "Arguments:" >&2
    echo "  ZAP_REPORT_URL   URL to the ZAP XML report endpoint" >&2
    echo "  OUTPUT_FILENAME   Optional custom filename (saved under results/)" >&2
    echo "  API_KEY           Optional ZAP API key (passed via header, not in URL)" >&2
    echo "" >&2
    echo "Examples:" >&2
    echo "  $0 http://172.17.0.3:8090/OTHER/core/other/xmlreport/" >&2
    echo "  $0 http://zap:8090/OTHER/core/other/xmlreport/ my-zap-results.xml" >&2
    echo "  $0 http://zap:8090/OTHER/core/other/xmlreport/ \"\" my-secret-api-key" >&2
    exit 1
fi

zap_url="$1"

if [ -n "${2:-}" ]; then
    filename="$2"
else
    benchmark_version=$(scripts/getBenchmarkVersion.sh)
    if [ -z "${benchmark_version}" ]; then
        echo "ERROR: Could not determine Benchmark version from pom.xml." >&2
        exit 1
    fi
    date_stamp=$(date +%Y%m%d)
    filename="Benchmark_${benchmark_version}-ZAP-${date_stamp}.xml"
fi

api_key="${3:-}"

mkdir -p results/
output="results/${filename}"

curl_args=(-sS -o "${output}" -w '%{http_code}' --connect-timeout 10 --max-time 120)
if [ -n "${api_key}" ]; then
    curl_args+=(-H "X-ZAP-API-Key: ${api_key}")
fi

echo "Downloading ZAP report from: ${zap_url}"
http_code=$(curl "${curl_args[@]}" "${zap_url}")

if [ "${http_code}" -ne 200 ]; then
    echo "ERROR: Download failed with HTTP status ${http_code}" >&2
    rm -f "${output}"
    exit 1
fi

if ! head -2 "${output}" | grep -q "OWASPZAPReport"; then
    echo "ERROR: Downloaded file does not appear to be a ZAP XML report." >&2
    echo "First 3 lines of downloaded content:" >&2
    head -3 "${output}" >&2
    rm -f "${output}"
    exit 1
fi

echo "ZAP report saved to: ${output}"
echo "To generate the scorecard, run: ./createScorecards.sh"
