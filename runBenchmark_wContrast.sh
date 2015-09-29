#!/bin/sh

if [ -f tools/Contrast/contrast.jar ]; then

  if [ -d tools/Contrast/findings ]; then

    rm -r tools/Contrast/findings
    rm -r tools/Contrast/working
    echo ""
    echo "Previous Contrast results in tools/Contrast/findings removed"
    echo ""

  fi

  chmod 755 src/main/resources/insecureCmd.sh
  mvn clean package cargo:run -Pdeploywcontrast

else 

  echo "Given that Contrast is a commercial product, you have to have a licensed version of Contrast in order to run it on the Benchmark. If you have access to Contrast, download the Java 1.5 version of contrast.jar from the Team Server and put it into the /tools/Contrast folder, and then rerun this script."

fi
