source "scripts/verifyBenchmarkPluginAvailable.sh"
mvn -Djava.awt.headless=true org.owasp:benchmarkutils-maven-plugin:create-scorecard -DconfigFile=data/anonymousScoringConfig.yaml

