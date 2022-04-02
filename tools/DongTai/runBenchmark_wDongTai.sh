#!/bin/sh


# Check if contrast.jar is there and is less than 24 hours old. If so, don't bother to download again
if $(find dongtai.jar -mmin +1440); then
  echo "Using DongTai agent downloaded in past day"
else
  echo "Fetching the latest DongTai agent"
  curl -o dongtai.jar -L "https://iast.io/openapi/api/v1/agent/download?url=https://iast.io/openapi&language=java" -H 'Authorization: Token 79798299b48839c84886d728958a8f708e119868'
fi

echo
echo "Starting Benchmark application server with DongTai agent"
echo "  1. Verify that the output shows \"Starting JVM\"."
echo "  2. If the output contains \"Continuing without DongTai...\" the credentials in contrast.yaml are most likely incorrect or missing."
echo "  3. Once the Benchmark server is fully started, open another terminal window and run the runCrawler.sh script from the Benchmark root directory."
echo "  4. When the crawler finishes (takes a minute or two), hit CTRL+C in this window to stop the server and write the DongTai results to the /results folder."
echo
echo "========================================================================================================================"

cd ../..
mvn clean package cargo:run -Pdeploywdongtai


