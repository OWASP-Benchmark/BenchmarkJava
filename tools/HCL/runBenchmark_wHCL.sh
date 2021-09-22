#!/bin/sh

if [ -f ./secagent.jar ]; then

  if [ -d ./working ]; then

    rm -r ./working/HCL-IAST.hcl
    echo ""
    echo "Previous  results in /working removed"
    echo ""

  fi

  cd ../..
  mvn clean package cargo:run -Pdeploywhcl

  echo "Copying report to results directory"
  benchmark_version=$(scripts/getBenchmarkVersion.sh)
  result_file="results/Benchmark_$benchmark_version-HCL-IAST.hcl"
  cp tools/HCL/working/HCL-IAST.hcl "$result_file"
  cd tools/HCL

else 

  echo "secagent.jar is required to run the Benchmark with HCL IAST. Please contact HCL at https://www.hcl.com/."

fi

