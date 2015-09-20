#!/bin/sh

# TODO - Get the Benchmark version and put that in the file name

if [ -d forcontrast/findings ]; then

  # clean out any APPCREATE, APPUPDATE, and SERVER events out of the Contrast findings directory before zipping everything up

   forcontrast/removeUnneededEvents.sh forcontrast/findings/APP*.xml
   forcontrast/removeUnneededEvents.sh forcontrast/findings/SERVER*.xml

   echo
   echo "All unneeded Contrast events removed from forcontrast/findings before zipping them up"

   zip -q -r results/Benchmark_1.2beta-Contrast.zip forcontrast/findings && echo "Contrast findings ZIP file successfully created" || echo "Error creating Contrast findings ZIP file"

   echo "Contrast findings all put into /results folder"
   echo

else

   echo ""
   echo "ERROR: The forcontrast/findings directory doesn’t exist. You need to run the runBenchmark_wContrast script first, and then crawl the Benchmark app with runCrawler to generate the Contrast results required by this script."
   echo ""

fi

