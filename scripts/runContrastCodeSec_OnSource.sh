# To use Contrast CodeSec you have to install it first.
# See the install instructions at: https://www.contrastsecurity.com/developer/codesec/ 

# For example, on Mac:
# brew tap contrastsecurity/tap
# brew install contrast

# To scan the source code you have to create a .zip of the src/ directory so src.zip exists in the project's root folder.

if [ -f "./src.zip" ]; then

# Note: you have to do 'contrast auth' first, and successfully authenticate before you can run this.
benchmark_version=$(scripts/getBenchmarkVersion.sh)

contrast scan -f src.zip --timeout=10000 --save
mv results.sarif results/Benchmark_$benchmark_version-ContrastCodeSec_OnSrc.sarif

else
  echo "ERROR: You must create a .zip of the src directory first, before running this script."
fi

