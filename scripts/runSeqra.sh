#!/usr/bin/env bash

# Check for install/updates at https://github.com/seqra/seqra

source scripts/requireCommand.sh

requireCommand docker

docker pull ghcr.io/seqra/seqra

benchmark_version=$(scripts/getBenchmarkVersion.sh 2>/dev/null | tail -1)
seqra_version=$(docker run --rm ghcr.io/seqra/seqra seqra --version | grep -oE 'v[0-9]+\.[0-9]+\.[0-9]+')
result_file="/project/results/Benchmark_$benchmark_version-Seqra-$seqra_version.sarif"

docker run --rm -v $(pwd):/project \
  ghcr.io/seqra/seqra:latest \
  seqra scan \
  --severity error \
  --severity warning \
  --severity note \
  --output "$result_file" /project
