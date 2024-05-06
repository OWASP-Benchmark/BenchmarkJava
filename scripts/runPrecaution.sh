# To install Precaution CLI:
#   pip install precli
# 
# See also: https://precli.readthedocs.io/latest/
benchmark_version=$(scripts/getBenchmarkVersion.sh)
precli -r . --json -o results/Benchmark_$benchmark_version-Precaution.json
