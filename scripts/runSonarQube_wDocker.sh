#!/usr/bin/env bash

# this script will
# - create a sonarqube server using the default configuration
# - setup basic things (account, project, token)
# - start a scan (takes >= 1 hour on mac)
# - create a report file
# - shutdown sonarqube server

source scripts/requireCommand.sh

requireCommand curl
requireCommand docker
requireCommand jq

# Check for install/updates at https://github.com/SonarSource/sonarqube

sonar_port="9876"
sonar_host="http://localhost:$sonar_port"
sonar_project="benchmark"
sonar_user="admin"
sonar_default_password="admin"
sonar_password="password"

echo "Creating temporary SonarQube instance"

docker pull sonarqube

# start local sonarqube
container_id=$(docker run --rm -d -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p "$sonar_port:9000" sonarqube)

echo "Waiting for instance to come up"

# wait for container to come up
while [[ "$(curl --connect-timeout 5 --max-time 5 --retry 60 --retry-delay 0 --retry-max-time 120 -s -o /dev/null -w '%{http_code}' "$sonar_host")" != "200" ]]; do
  sleep 3;
done

# wait for sonarqube to be started
while [[ "$(curl --silent "$sonar_host/api/system/status" | jq -r '.status')" != "UP" ]]; do
  sleep 3;
done

echo "Setting up instance"

# change default password
curl "$sonar_host/api/users/change_password" --silent -u "$sonar_user:$sonar_default_password" -X POST --data-raw "login=$sonar_user&password=$sonar_password&previousPassword=$sonar_default_password" -o /dev/null

# create project
curl "$sonar_host/api/projects/create" --silent -u "$sonar_user:$sonar_password" -X POST --data-raw "project=$sonar_project&name=$sonar_project" -o /dev/null

# create token
sonar_token=$(curl "$sonar_host/api/user_tokens/generate" --silent -u "$sonar_user:$sonar_password" -X POST --data-raw "name=$(date)" | jq -r '.token')

echo "Starting scan (might take some time!)"

# run scan (using net=host to be able to connect to localhost sonarqube)
docker run --env SONAR_SCANNER_OPTS=-Xmx4g --net=host --rm -v ~/.m2:/root/.m2 -v "$(pwd)":"$(pwd)" -w "$(pwd)" sonarsource/sonar-scanner-cli \
  -Dsonar.java.binaries="target" -Dsonar.projectKey="$sonar_project" -Dsonar.host.url="$sonar_host" -Dsonar.login="$sonar_token" \
  -Dsonar.sources="src" -Dsonar.exclusions="results/**,scorecard/**,scripts/**,tools/**,VMs/**"

echo "Waiting for SonarQube CE to finish task"

while [[ "$(curl --silent -u "$sonar_token:" "$sonar_host/api/ce/component?component=$sonar_project" | jq -r '.current.status')" != "SUCCESS" ]]; do
  sleep 3;
done

echo "Generating report..."

benchmark_version=$(scripts/getBenchmarkVersion.sh)
sonarqube_version=$(curl --silent -u "$sonar_token:" "$sonar_host/api/server/version")
result_file="results/Benchmark_$benchmark_version-sonarqube-v$sonarqube_version.json"

# SonarQube does not provide a download option so we've to create the result file manually :(

result='{"issues":[], "hotspots": []}'
rules='[]'

# sonarqube does not allow us to grab more than 10k issues, but most of them are information exposure which is not even
# considered by benchmark so let's just get all relevant rules and receive results for only those rules

rules_count=$(curl --silent -u "$sonar_token:" "$sonar_host/api/rules/search?p=1&ps=1" | jq -r '.total')
page=1

while (((page - 1) * 500 < rules_count)); do
  rules=$(echo "$rules" | jq ". += $(curl --silent -u "$sonar_token:" "$sonar_host/api/rules/search?p=$page&ps=500" | jq '.rules | map( .key ) | map( select(. | contains("java:") ) )')")
  page=$((page+1))
done

rules=$(echo "$rules" | jq '. | join(",")' | sed 's/java:S1989,//')

issues_count=$(curl --silent -u "$sonar_token:" "$sonar_host/api/issues/search?p=1&ps=1&types=VULNERABILITY&componentKeys=$sonar_project&rules=$rules" | jq -r '.paging.total')
page=1

while (((page - 1) * 500 < issues_count)); do
  issues_page=$(curl --silent -u "$sonar_token:" "$sonar_host/api/issues/search?types=VULNERABILITY&p=$page&ps=500&componentKeys=$sonar_project&rules=$rules" | jq '.issues')

  result=$(echo "$result" | jq ".issues += $issues_page")
  page=$((page+1))
done

hotspot_count=$(curl --silent -u "$sonar_token:" "$sonar_host/api/hotspots/search?projectKey=benchmark&p=1&ps=1" | jq -r '.paging.total')
page=1

while (((page - 1) * 500 < hotspot_count)); do
  result=$(echo "$result" | jq ".hotspots += $(curl --silent -u "$sonar_token:" "$sonar_host/api/hotspots/search?projectKey=$sonar_project&p=$page&ps=500" | jq '.hotspots')")
  page=$((page+1))
done

echo "$result" > "$result_file"

echo "Shutting down SonarQube"

docker stop "$container_id"
