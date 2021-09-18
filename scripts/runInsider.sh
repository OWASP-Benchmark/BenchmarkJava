#!/usr/bin/env bash

# Check for install/updates at https://github.com/insidersec/insider

if ! command -v insider &> /dev/null; then
    echo "Insider not found. Visit https://github.com/insidersec/insider and follow installation instructions"
    exit 1
fi

source scripts/requireCommand.sh

requireCommand curl
requireCommand jq

benchmark_version=$(scripts/getBenchmarkVersion.sh)
insider_version=$(insider -version | grep Version | cut -d' ' -f2)
result_file="results/Benchmark_$benchmark_version-insider-v$insider_version.json"
most_recent_insider_version=$(curl -H "Accept: application/vnd.github.v3+json" --silent https://api.github.com/repos/insidersec/insider/tags | jq -r '.[0].name')

if [ "$insider_version" != "$most_recent_insider_version" ]; then
  echo "You're using insider $insider_version, but $most_recent_insider_version is available. You should update your installation."
fi

insider -quiet --tech java -no-html -exclude '.idea' -exclude '.mvn' -exclude 'results' -exclude 'scorecard' -exclude 'scripts' -exclude 'tools' -target "."
mv report.json "$result_file"
