#!/bin/sh
source "scripts/verifyBenchmarkPluginAvailable.sh"
if [ $# -eq 2 ]; then
    mvn org.owasp:benchmarkutils-maven-plugin:run-crawler -DcrawlerFile=data/benchmark-crawler-http.xml -DproxyHost="$1" -DproxyPort="$2"
elif [ $# -eq 0 ]; then
    mvn org.owasp:benchmarkutils-maven-plugin:run-crawler -DcrawlerFile=data/benchmark-crawler-http.xml
else
    echo "Error!!"
    echo "-------"
    echo "To run the Crawler for localhost, execute runCrawler.sh with no arguments."
    echo "To run the Crawler for remote host, execute runCrawler.sh with only 2 arguments, proxy-host and proxy-port."
    echo "Example: ./runCrawler.sh 192.168.0.1 53452"
fi
