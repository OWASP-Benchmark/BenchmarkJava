#!/usr/bin/env bash

# Check for install/updates at https://github.com/ShiftLeftSecurity/sast-scan

source scripts/requireDocker.sh

benchmark_version=$(scripts/getBenchmarkVersion.sh)
shiflteft_version="2.0.3" # it's not (yet) possible to get the release version so we just assume it
result_file="results/Benchmark_$benchmark_version-shiftleftscan-v$shiflteft_version.json"

mkdir -p .shiftlefscan-reports

docker run --rm -e "WORKSPACE=${PWD}" -v ~/.m2:/.m2 -v "$PWD":/app -v "$PWD/.shiftlefscan-reports":/app/reports shiftleft/scan scan --src /app --type java
mv .shiftlefscan-reports/scan-full-report.json "$result_file"

rm -rf .shiftlefscan-reports
