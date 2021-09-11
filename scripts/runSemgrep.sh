#!/usr/bin/env sh

# Check for install/updates at https://github.com/returntocorp/semgrep

benchmark_version=$(scripts/getBenchmarkVersion.sh)
semgrep_version=$(semgrep --version)
result_file="results/Benchmark_$benchmark_version-semgrep-v$semgrep_version.json"

semgrep --config p/security-audit -q --json -o "$result_file" . > /dev/null
