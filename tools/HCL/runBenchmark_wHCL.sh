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
  cp tools/HCL/working/HCL-IAST.hcl results/HCL-IAST.hcl
  cd tools/HCL

else 

  echo "secagent.jar is required to run this benchmark. Please contact HCL at https://www.hcl.com/."

fi
