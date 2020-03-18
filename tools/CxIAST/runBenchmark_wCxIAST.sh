#!/bin/sh

if [ -f ./cx-launcher.jar ]; then

  if [ -d ./iast_cache ]; then

    rm -r ./iast_cache

    if [ -d ./logs ]; then

      rm -r ./logs

    fi

    echo ""
    echo "Previous Checkmarx IAST results in tools/CxIAST removed"
    echo ""

  fi

  cd ../..
  chmod 755 target/classes/insecureCmd.sh
  mvn clean package cargo:run -Pdeploywcxiast

  echo "Download Checkmarx IAST report to results directory"

else

  echo "Checkmarx IAST is a commercial product, so you need a licensed version of Checkmarx IAST in order to run it on the Benchmark. If you have access to Checkmarx IAST and want to run the Benchmark against it you will have to:
    *  download the CxIAST Agent for Java (cxiast-java-agent.zip) from the Server;
    *  put it into the /tools/CxIAST folder;
    *  unzip it; and then
    *  rerun this script."

fi
