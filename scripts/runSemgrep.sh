#!/usr/bin/env bash

# Check for install/updates at https://semgrep.dev/docs/update/

source scripts/requireCommand.sh

requireCommand docker

docker pull semgrep/semgrep

benchmark_version=$(scripts/getBenchmarkVersion.sh)
semgrep_version=$(docker run --rm semgrep/semgrep semgrep --version)
result_file="/src/results/Benchmark_$benchmark_version-Semgrep-v$semgrep_version.sarif"

docker run --rm -v "${PWD}:/src" semgrep/semgrep semgrep --config p/security-audit -q --sarif -o "$result_file" . > /dev/null

