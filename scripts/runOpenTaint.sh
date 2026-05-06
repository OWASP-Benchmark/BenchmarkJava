#!/usr/bin/env bash

# Check for install/updates at https://github.com/seqra/opentaint

source scripts/requireCommand.sh

requireCommand docker

docker pull ghcr.io/seqra/opentaint

benchmark_version=$(scripts/getBenchmarkVersion.sh 2>/dev/null | tail -1)
opentaint_version=$(docker run --rm ghcr.io/seqra/opentaint opentaint --version | awk '{print $NF}')
result_file="/project/results/Benchmark_$benchmark_version-OpenTaint-$opentaint_version.sarif"

docker run --rm -v $(pwd):/project \
  ghcr.io/seqra/opentaint:latest \
  opentaint scan \
  --severity error \
  --severity warning \
  --severity note \
  --output "$result_file" /project
