#!/bin/sh

if [ -f ./secpoint.jar ]; then
      if [ -f ../../results/security.sec ]; then
         rm -f ../../results/security.sec
      fi
      if [ -f ./secpoint.log ]; then
         rm -f secpoint.log
      fi
      if [ -f ./secpoint.properties ]; then
         rm -f secpoint.properties
      fi
      cd ../..
      mvn clean package cargo:run -Pdeploywsecpoint
else
  echo "Secpoint is a commercial product, so you need a licensed version of Secpoint in order to run it on the Benchmark. If you have access to Contrast, download the Secpoint Agent for Java (secpoint.jar) from the Team Server and put it into the /tools/Secpoint folder, and then rerun this script. If you don't have a license for Secpoint, you can probably use the free Secpoint Community Edition (CE) on Benchmark. See: https://www.tcsec.com.cn/

fi