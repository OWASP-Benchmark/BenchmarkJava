#!/bin/sh

if [ -f ./secagent.jar ]; then

  if [ -d ../../results/HCL-IAST.hcl ]; then

    rm ../../results/HCL-IAST.hcl
    echo ""
    echo "Previous results have been removed"
    echo ""

  fi

  cd ../..
  mvn clean package cargo:run -Pdeploywhcl -Drunenv=remote

else 

  echo "secagent.jar is required to run the Benchmark with HCL IAST. Please contact HCL at https://www.hcl.com/."

fi

