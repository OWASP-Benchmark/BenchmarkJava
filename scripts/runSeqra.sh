#!/usr/bin/env bash

# For details about Seqra, check https://github.com/seqra/seqra

source scripts/requireCommand.sh

requireCommand docker

docker pull ghcr.io/seqra/seqra

benchmark_version=$(scripts/getBenchmarkVersion.sh)
seqra_version=$(docker run --rm ghcr.io/seqra/seqra seqra --version | awk '{print $NF}')
result_file="/src/results/Benchmark_$benchmark_version-Seqra-$seqra_version.sarif"

docker run --rm -v "${PWD}:/src" ghcr.io/seqra/seqra seqra scan --output "$result_file" /src
