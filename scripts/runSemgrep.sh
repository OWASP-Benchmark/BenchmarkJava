#!/usr/bin/env bash

# Check for install/updates at https://github.com/returntocorp/semgrep

source scripts/requireCommand.sh

requireCommand docker

docker pull returntocorp/semgrep

benchmark_version=$(scripts/getBenchmarkVersion.sh)
semgrep_version=$(docker run --rm returntocorp/semgrep semgrep --version)
result_file="/src/results/Benchmark_$benchmark_version-Semgrep-v$semgrep_version.json"

docker run --rm -v "${PWD}:/src" returntocorp/semgrep semgrep --config p/security-audit -q --json -o "$result_file" . > /dev/null
