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

if ! command -v "sonar-report" &> /dev/null; then
  echo "sonar-report is required. Please install it via https://github.com/soprasteria/sonar-report and then try again."
  exit 1
fi

# Check for install/updates at https://github.com/SonarSource/sonarqube

container_name="sonarqube-benchmark"
sonar_external_port="9876"
sonar_internal_port="9000"
sonar_host="http://localhost:$sonar_external_port"
sonar_project="benchmark"
sonar_user="admin"
sonar_default_password="admin"
sonar_password="P4ssword!!!!"

echo "Creating temporary SonarQube instance..."

#docker pull sonarqube
#docker pull sonarsource/sonar-scanner-cli

# start local sonarqube
docker run --rm -d --name "$container_name" -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p "$sonar_external_port:$sonar_internal_port" sonarqube

echo "Waiting for SonarQube to start..."

while [[ "$(curl --connect-timeout 5 --max-time 5 --retry 60 --retry-delay 0 --retry-max-time 120 -s -o /dev/null -w '%{http_code}' "$sonar_host")" != "200" ]]; do
  echo -n "."
  sleep 3
done

echo "Waiting for SonarQube to become ready..."

while [[ "$(curl --silent "$sonar_host/api/system/status" | jq -r '.status')" != "UP" ]]; do
  echo -n "."
  sleep 3
done

echo "SonarQube ready. Setting up instance..."

# change default password
curl "$sonar_host/api/users/change_password" --silent -u "$sonar_user:$sonar_default_password" -X POST --data-raw "login=$sonar_user&password=$sonar_password&previousPassword=$sonar_default_password" -o /dev/null

# create project
curl "$sonar_host/api/projects/create" --silent -u "$sonar_user:$sonar_password" -X POST --data-raw "project=$sonar_project&name=$sonar_project" -o /dev/null

# create token
sonar_token=$(curl "$sonar_host/api/user_tokens/generate" --silent -u "$sonar_user:$sonar_password" -X POST --data-raw "name=$(date)" | jq -r '.token')

echo "Starting scan... (might take some time!)"

container_ip=$(docker inspect "$container_name" | jq -r '.[0].NetworkSettings.Networks.bridge.IPAddress' )
sonar_docker_host="http://$container_ip:$sonar_internal_port"

docker run --env SONAR_SCANNER_OPTS=-Xmx4g --rm -v ~/.m2:/root/.m2 -v "$(pwd)":"$(pwd)" -w "$(pwd)" sonarsource/sonar-scanner-cli \
  -Dsonar.java.binaries="target" \
  -Dsonar.projectKey="$sonar_project" \
  -Dsonar.host.url="$sonar_docker_host" \
  -Dsonar.login="$sonar_token" \
  -Dsonar.sources="src" \
  -Dsonar.exclusions="results/**,scorecard/**,scripts/**,tools/**,VMs/**"

echo "Waiting for SonarQube CE to finish task..."

while [[ "$(curl --silent -u "$sonar_token:" "$sonar_host/api/ce/component?component=$sonar_project" | jq -r '.current.status')" != "SUCCESS" ]]; do
  echo -n "."
  sleep 3
done

echo "Generating report..."

benchmark_version=$(scripts/getBenchmarkVersion.sh)
sonarqube_version=$(curl --silent -u "$sonar_token:" "$sonar_host/api/server/version")
result_file="results/Benchmark_$benchmark_version-sonarqube-v$sonarqube_version.json"

sonar-report --sonarurl "$sonar_host" --sonarcomponent="$sonar_project" --sonarusername "$sonar_user" --sonarpassword 'P4ssword!!!!' --allbugs --no-rules-in-report --save-report-json "$result_file"

echo "Result file written to $result_file"
echo "Shutting down SonarQube..."

docker stop "$container_name"
