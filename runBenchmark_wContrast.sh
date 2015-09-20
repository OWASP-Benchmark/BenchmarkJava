#!/bin/sh

if [ -f forcontrast/contrast.jar ]; then

  if [ -d forcontrast/findings ]; then

    rm -r forcontrast/findings
    rm -r forcontrast/working
    echo ""
    echo "Previous Contrast results in forcontrast/findings removed"
    echo ""

  fi

  chmod 755 src/main/resources/insecureCmd.sh
  mvn clean package cargo:run -Pdeploywcontrast

else 

  echo "Given that Contrast is a commercial product, you have to have a licensed version of Contrast in order to run it on the Benchmark. If you have access to Contrast, download the Java 1.5 version of contrast.jar from the Team Server and put it into the /forcontrast folder, and then rerun this script."

fi
