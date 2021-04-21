#!/bin/sh

if [ -f ./seeker-agent.jar ]; then

    echo ""
    echo "Previous Seeker results in tools/seeker removed"
    echo ""

  fi

  cd ../..
  chmod 755 target/classes/insecureCmd.sh
  mvn clean package cargo:run -Pdeploywseeker

  echo "Download Seeker report to results directory"

else

  echo "Synopsys Seeker IAST is a commercial product, so you need a licensed version of Seeker from Synopsys in order to run it on the Benchmark. If you have access to Seeker IAST and want to run the Benchmark against it you will have to:
    *  download the Seeker Agent for Java (seeker-agent.zip) from the Server;
    *  put it into the /tools/seeker folder;
    *  unzip it;
    *  update pom.xml (deploywseeker section, seeker.server.url); and then
    *  rerun this script."

fi
