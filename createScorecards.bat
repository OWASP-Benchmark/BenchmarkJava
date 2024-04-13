# source "scripts/verifyBenchmarkPluginAvailable.sh" - Don't have .bat version of this (yet)
call mvn -Djava.awt.headless=true org.owasp:benchmarkutils-maven-plugin:create-scorecard

