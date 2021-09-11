#!/usr/bin/env sh

# Check for install/updates at https://github.com/ZupIT/horusec

benchmark_version=$(scripts/getBenchmarkVersion.sh)
horusec_version=$(horusec version 2>&1 | grep version | awk '{print $NF}')
result_file="results/Benchmark_$benchmark_version-horusec-$horusec_version.json"

horusec start -t 3600 -p="." -o="json" -O="$result_file"
