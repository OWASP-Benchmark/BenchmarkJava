# Install Snyk per: https://docs.snyk.io/snyk-cli/install-or-update-the-snyk-cli
# Before running this, you must first run: snyk auth (and then authenticate) so snyk code is authorized to run.

benchmark_version=$(scripts/getBenchmarkVersion.sh)
Snyk_version=$(snyk-win -v)

snyk-win code test --sarif-file-output=results/Benchmark_$benchmark_version-snykCodeCli-v$Snyk_version-$SECONDS.sarif

