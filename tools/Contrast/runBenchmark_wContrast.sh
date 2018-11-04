#!/bin/sh

if [ -f ./contrast.jar ]; then

  if [ -d ./working ]; then

    rm -r ./working/cache
    rm -r ./working/contrast.log
    echo ""
    echo "Previous Contrast results in tools/Contrast/working removed"
    echo ""

  fi

  cd ../..
  chmod 755 target/classes/insecureCmd.sh
  mvn clean package cargo:run -Pdeploywcontrast

  echo "Copying Contrast report to results directory"
  cp tools/Contrast/working/contrast.log results/Benchmark_1.2-Contrast.log
  cd tools/Contrast

else 

  echo "Contrast is a commercial product, so you need a licensed version of Contrast in order to run it on the Benchmark. If you have access to Contrast, download the Contrast Agent for Java (contrast.jar) from the Team Server and put it into the /tools/Contrast folder, and then rerun this script. If you don't have a license for Contrast, you can probably use the free Contrast Community Edition (CE) on Benchmark. See: https://www.contrastsecurity.com/community-edition-lp"

fi
