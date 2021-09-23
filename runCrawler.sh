source "scripts/verifyBenchmarkPluginAvailable.sh"
mvn org.owasp:benchmarkutils-maven-plugin:run-crawler -DcrawlerFile=data/benchmark-crawler-http.xml

