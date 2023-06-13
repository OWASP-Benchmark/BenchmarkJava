#!/usr/bin/env bash
## This script Launches the benchmark, populates results on Sonarqube Dashboard and then fetch same results back from the SonarQube Server using SONAR Host,Project and Token
## This Script is totaly experimental. Tested Against SonarQube Enterprise Server version 9.9 LTS
## To run SonarQube benchmark you need to be on the /BenchmarkJava path and run ./scripts/runSonarQube.sh

source scripts/requireCommand.sh

requireCommand curl
requireCommand jq

# Check for install/updates at https://github.com/SonarSource/sonarqube
# This is Page size, If facing JQ Errors due to Long Arguments, Decrease this Number. Tested with SonarQube 9.9 LTS, 50 and 100 where producing lots of errors,
elements_per_request=20

if [ ! -f scripts/SonarQubeCredentials.sh ]; then cat > scripts/SonarQubeCredentials.sh << EOF
#!/usr/bin/env bash
sonar_host="" # e. g. http://localhost:9000
sonar_project=""
sonar_token=""
EOF
 chmod +x scripts/SonarQubeCredentials.sh
fi 

source scripts/SonarQubeCredentials.sh

if [ -z "$sonar_host" ] || [ -z "$sonar_project" ] || [ -z "$sonar_token" ]; then
  echo "Please provide credentials in SonarQubeCredentials.sh"
  exit 1
fi

mvn sonar:sonar -Dsonar.projectKey="$sonar_project" -Dsonar.host.url="$sonar_host" -Dsonar.login="$sonar_token"

sleep 300

benchmark_version=$(scripts/getBenchmarkVersion.sh)
sonarqube_version=$(curl --silent -u "$sonar_token:" "$sonar_host/api/server/version")
result_file="results/Benchmark_$benchmark_version-sonarqube-v$sonarqube_version.json"

# SonarQube does not provide a download option so we've to create the result file manually :(

result='{"issues":[], "hotspots": []}'
rules='[]'


## WE ARE GOING TO DISCARD RULE CHERRY PICKING. SO ALL RESULTS ARE REPORTED REGARDLESS SO THAT BENCHMARK CAN POPULATE RESULTS & SCORE ACCORDINGLY.
## The content/data structure returned is controled by SONARQUEBE end server, Benchmark Script picks them accordingly and match them back to test cases and create the score. 
## If returned data are not structured in a way expected by Benchmark/Score calculator. Example: CWE/DataPoint missed then results will not be counted/scored. This can end up in in-correct/Lower Score calculation. 
## rules_count=$(curl --silent -u "$sonar_token:" "$sonar_host/api/rules/search?p=1&ps=1" | jq -r '.total')
##page=1
##echo "rule count is: $rules_count"

## while (((page - 1) * elements_per_request < rules_count)); do
##  rules=$(echo "$rules" | jq ". += $(curl --silent -u "$sonar_token:" "$sonar_host/api/rules/search?p=$page&ps=$elements_per_request" | jq '.rules | map( .key ) | map( select(. | contains("java:") ) )')")
##  page=$((page+1))
##  echo "rule page: $page"
##  sleep 1;
## done
## rules=$(echo "$rules" | jq '. | join(",")' | sed 's/java:S1989,//')

issues_count=$(curl --silent -u "$sonar_token:" "$sonar_host/api/issues/search?p=1&ps=1&types=VULNERABILITY&componentKeys=$sonar_project" | jq -r '.paging.total')
page=1

echo "Vulnerability Issue count is: $issues_count"

## We are using two files to write results to. One as buffer the other as final to incrementally add results and swap in-between.
## This helps to have some sort of fault tolerance. If jq hits long argument or sonarqube sends back impaired data/empty for a single page, previous progress of result collection will not be erased/lost retroactively.
echo '{"issues":[], "hotspots": []}' > buffdump.json;
echo '{"issues":[], "hotspots": []}' > resdump.json;

while (((page - 1) * elements_per_request < issues_count)); do
 cat resdump.json > buffdump.json;
 itemcount=$(($page * $elements_per_request))
 echo "processing Vulnerablity issues, page: $page up to $itemcount items out of total $issues_count"
 issues_page=$(curl --silent -u "$sonar_token:" "$sonar_host/api/issues/search?types=VULNERABILITY&p=$page&ps=$elements_per_request&componentKeys=$sonar_project" | jq '.issues') 
 if [ "$issues_page" ]; then
   cat buffdump.json | jq ".issues += ${issues_page}" > resdump.json;
 else
   echo "Empty. Error reading Vulnerability issues at Page:$page !"
 fi
 page=$((page+1))
done
 
hotspot_count=$(curl --silent -u "$sonar_token:" "$sonar_host/api/hotspots/search?projectKey=$sonar_project&p=1&ps=1" | jq -r '.paging.total')
page=1
echo "Hotspot Count is: $hotspot_count"

cat resdump.json > buffdump.json
while (((page - 1) * elements_per_request < hotspot_count)); do
  cat resdump.json > buffdump.json
  itemcount=$(($page * $elements_per_request))
  echo "processing Hotspots, page: $page up to $itemcount items out of total $hotspot_count"
  hotspot_page=$(curl --silent -u "$sonar_token:" "$sonar_host/api/hotspots/search?projectKey=$sonar_project&p=$page&ps=$elements_per_request" | jq '.hotspots')
  if [ "$hotspot_page" ]; then
    cat buffdump.json | jq ".hotspots += ${hotspot_page}" > resdump.json;
  else
    echo "Empty. Error reading Hotspot at Page:$page !"
  fi
  page=$((page+1))
done
echo "Writing end results json content";
cp resdump.json "${result_file}";
echo "Done, please go ahead an generate the scorecard";
## cleanup the two files generated to record results, if want them for debug, you can comment the following line
rm resdump.json buffdump.json;

