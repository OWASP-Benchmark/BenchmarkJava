# source "scripts/verifyBenchmarkPluginAvailable.sh" - Don't have .bat version of this (yet)
# The buildtime elements when invoking the Spotbugs plugin leverage the buildtime extension specified in: .mvn/extensions.xml
call mvn compile spotbugs:spotbugs -Dbuildtime.output.csv=true -Dbuildtime.output.csv.file=../data/out.csv
call mvn org.owasp:benchmarkutils-maven-plugin:append-time -DtoolName=spotbugs

