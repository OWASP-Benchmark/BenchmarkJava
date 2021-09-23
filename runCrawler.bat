# source "scripts/verifyBenchmarkPluginAvailable.sh" - Don't have .bat version of this (yet)
CALL mvn org.owasp:benchmarkutils-maven-plugin:run-crawler -DcrawlerFile=data/benchmark-crawler-http.xml

