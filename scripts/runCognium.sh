#!/usr/bin/env bash

# Install: npm install -g cognium
# Check for install/updates at https://github.com/cogniumhq/cognium

source scripts/requireCommand.sh

requireCommand cognium

benchmark_version=$(scripts/getBenchmarkVersion.sh 2>/dev/null | grep -E '^[0-9]+\.[0-9]')
cognium_version=$(cognium --version | grep -oE '[0-9]+\.[0-9]+\.[0-9]+')
result_file="results/Benchmark_$benchmark_version-cognium-v$cognium_version.sarif"

cognium scan src/main/java --format sarif --category security --output "$result_file"
