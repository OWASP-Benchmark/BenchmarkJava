#!/usr/bin/env sh

# Check for install/updates at https://github.com/insidersec/insider

benchmark_version=$(scripts/getBenchmarkVersion.sh)
insider_version=$(insider -version | grep Version | cut -d' ' -f2)
result_file="results/Benchmark_$benchmark_version-insider-v$insider_version.json"

insider -quiet --tech java -no-html -exclude '.idea' -exclude '.mvn' -exclude 'results' -exclude 'scorecard' -exclude 'scripts' -exclude 'tools' -target "."
mv report.json "$result_file"
