# Note: you have to do 'contrast auth' first, and successfully authenticate before you can run this.
benchmark_version=$(scripts/getBenchmarkVersion.sh)

contrast scan -f target/benchmark.war --save
mv results.sarif results/Benchmark_$benchmark_version-ContrastCodeSec.sarif

