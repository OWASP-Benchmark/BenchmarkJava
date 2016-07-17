#!/bin/sh

if [ -f tools/Contrast/contrast.jar ]; then

  if [ -d tools/Contrast/working ]; then

    rm -r tools/Contrast/working/cache
    rm -r tools/Contrast/working/contrast.log
    echo ""
    echo "Previous Contrast results in tools/Contrast/findings removed"
    echo ""

  fi

  chmod 755 target/classes/insecureCmd.sh
  mvn clean package cargo:run -Pdeploywcontrast

  echo "Copying Contrast report to results directory"
  cp tools/Contrast/working/contrast.log results/Benchmark_1.2-Contrast.log

else 

  echo "Contrast is a commercial product, so you need a licensed version of Contrast in order to run it on the Benchmark. If you have access to Contrast, download the Contrast Agent for Java (contrast.jar) from the Team Server and put it into the /tools/Contrast folder, and then rerun this script."

fi
