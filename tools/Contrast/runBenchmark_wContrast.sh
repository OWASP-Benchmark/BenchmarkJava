#!/bin/sh

if grep -q "____" "contrast.yaml"; then
  echo
  echo "Contrast is a commercial product, so you need to provide your Contrast credentials in the contrast.yaml file in order to run it."
  echo "You can use your enterprise Contrast account or sign up for the free Contrast Community Edition (CE) at \"https://www.contrastsecurity.com/contrast-community-edition\"."
  echo "When logged in to the Contrast TeamServer, your credentials are available via \"User settings\" in the top right menu. See the Profile section 'YOUR KEYS'."
  echo
  echo "ERROR: ____ placeholders are still present in contrast.yaml file. Please provide your credentials as directed as they are required for you to proceed."
  echo
  exit 1
fi

# Check if contrast.jar is there and is less than 24 hours old. If so, don't bother to download again
if $(find contrast.jar -mmin +1440); then
  echo "Using Contrast agent downloaded in past day"
else
  echo "Fetching the latest Contrast agent"
  export VERSION=$(echo "$(curl --fail --silent "https://search.maven.org/solrsearch/select?q=g:"com.contrastsecurity"&a:"contrast-agent"&rows=20&wt=json" | jq -r '.response.docs[0].latestVersion')") && Curl --silent https://repo1.maven.org/maven2/com/contrastsecurity/contrast-agent/${VERSION}/contrast-agent-${VERSION}.jar -o contrast.jar
fi

if [ -d ./working ]; then

  echo
  echo "Removing previous Contrast results in ./working"
  rm -rf ./working/*

fi

echo
echo "Starting Benchmark application server with Contrast agent"
echo "  1. Verify that the output shows \"Starting JVM\"."
echo "  2. If the output contains \"Continuing without Contrast...\" the credentials in contrast.yaml are most likely incorrect or missing."
echo "  3. Once the Benchmark server is fully started, open another terminal window and run the runCrawler.sh script from the Benchmark root directory."
echo "  4. When the crawler finishes (takes a minute or two), hit CTRL+C in this window to stop the server and write the Contrast results to the /results folder."
echo
echo "========================================================================================================================"

cd ../..
mvn clean package cargo:run -Pdeploywcontrast

benchmark_version=$(scripts/getBenchmarkVersion.sh)

echo
echo "Copying Contrast report to results directory"
cd tools/Contrast
result_file="../../results/Benchmark_$benchmark_version-Contrast.log"
cp ./working/contrast.log "$result_file"
echo
echo "  5. You can generate a scorecard by running createScorecards.sh in the Benchmark root directory."
echo

