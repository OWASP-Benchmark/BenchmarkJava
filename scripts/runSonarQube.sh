#!/usr/bin/env bash

source scripts/requireCommand.sh

requireCommand curl
requireCommand jq

# Check for install/updates at https://github.com/SonarSource/sonarqube

if [ ! -f scripts/SonarQubeCredentials.sh ]; then
  cat > scripts/SonarQubeCredentials.sh << EOF
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

sleep 300s # might be replaced with polling of $sonar_host/api/ce/component?component=$sonar_project

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
