source "scripts/verifyBenchmarkPluginAvailable.sh"
# The buildtime elements when invoking the findbugs-maven-plugin leverage the buildtime extension specified in: .mvn/extensions.xml
mvn compile pmd:pmd -Dbuildtime.output.csv=true -Dbuildtime.output.csv.file=../data/out.csv
mvn org.owasp:benchmarkutils-maven-plugin:append-time -DtoolName=pmd

