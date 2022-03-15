#!/usr/bin/env bash

# Check for install/updates at https://github.com/ShiftLeftSecurity/sast-scan

source scripts/requireCommand.sh

requireCommand docker

benchmark_version=$(scripts/getBenchmarkVersion.sh)
shiflteft_version="2.0.4" # it's not (yet) possible to get the release version so we just assume it
result_file="results/Benchmark_$benchmark_version-ShiftLeftScan-v$shiflteft_version.json"

mkdir -p .shiftleftscan-reports

docker run --rm -e "WORKSPACE=${PWD}" -v ~/.m2:/.m2 -v "$PWD":/app -v "$PWD/.shiftleftscan-reports":/app/reports shiftleft/scan scan --src /app --type java
mv .shiftleftscan-reports/scan-full-report.json "$result_file"

rm -rf .shiftleftscan-reports
