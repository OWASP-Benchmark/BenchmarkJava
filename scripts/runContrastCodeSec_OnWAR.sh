# To use Contrast CodeSec you have to install it first.
# See the install instructions at: https://www.contrastsecurity.com/developer/codesec/ 

# For example, on Mac:
# brew tap contrastsecurity/tap
# brew install contrast

# Note: you have to do 'contrast auth' first, and successfully authenticate before you can run this.
benchmark_version=$(scripts/getBenchmarkVersion.sh)

contrast scan -f target/benchmark.war --save
mv results.sarif results/Benchmark_$benchmark_version-ContrastCodeSec_OnWAR.sarif

