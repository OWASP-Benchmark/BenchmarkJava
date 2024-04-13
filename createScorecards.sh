source "scripts/verifyBenchmarkPluginAvailable.sh"
MAVEN_OPTS="-Xmx8G" mvn -Djava.awt.headless=true org.owasp:benchmarkutils-maven-plugin:create-scorecard

