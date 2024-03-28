# Install Snyk per: https://docs.snyk.io/snyk-cli/install-or-update-the-snyk-cli
benchmark_version=$(scripts/getBenchmarkVersion.sh)
snyk code test --json-file-output=results/Benchmark_$benchmark_version-snykCodeCli.json

