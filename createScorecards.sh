source "scripts/verifyBenchmarkPluginAvailable.sh"
#mvn -Djava.awt.headless=true org.owasp:benchmarkutils-maven-plugin:create-scorecard -DconfigFile=config/score_v1.3config.yaml
mvn -Djava.awt.headless=true org.owasp:benchmarkutils-maven-plugin:create-scorecard

