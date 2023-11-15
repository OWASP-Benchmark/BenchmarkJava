#!/usr/bin/env bash

# Check for install/updates at https://github.com/bearer/bearer

source scripts/requireCommand.sh

requireCommand docker

docker pull bearer/bearer --platform linux/amd64

benchmark_version=$(scripts/getBenchmarkVersion.sh)
bearer_version=$(docker run --platform linux/amd64 bearer/bearer bearer --version | grep -o '[[:digit:]]\+\.[[:digit:]]\+\.[[:digit:]]\+')
result_file="/src/results/Benchmark_$benchmark_version-Bearer-v$bearer_version.json"

docker run --platform linux/amd64 --rm -v "${PWD}:/src" bearer/bearer scan /src/src/main/ --format jsonv2 --output "$result_file" > /dev/null
