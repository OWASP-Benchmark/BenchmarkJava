# source "scripts/verifyBenchmarkPluginAvailable.sh" - Don't have .bat version of this (yet)
#mvn -Djava.awt.headless=true org.owasp:benchmarkutils-maven-plugin:create-scorecard -DconfigFile=config/score_v1.3config.yaml
call mvn -Djava.awt.headless=true org.owasp:benchmarkutils-maven-plugin:create-scorecard

