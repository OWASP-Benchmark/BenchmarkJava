# Install Snyk per: https://docs.snyk.io/snyk-cli/install-or-update-the-snyk-cli
benchmark_version=$(scripts/getBenchmarkVersion.sh)
Snyk_version=$(snyk -v)

snyk code --sarif-file-output=results/Benchmark_$benchmark_version-snykCodeCli-v$Snyk_version.sarif

