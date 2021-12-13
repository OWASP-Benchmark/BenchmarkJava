# FindBugs is dead, so this specifies the specific (last) version of findbugs. Its version is not defined in the pom.xml file.
source "scripts/verifyBenchmarkPluginAvailable.sh"
# The buildtime elements when invoking the findbugs-maven-plugin leverage the buildtime extension specified in: .mvn/extensions.xml
mvn compile org.codehaus.mojo:findbugs-maven-plugin:3.0.5:findbugs -Dbuildtime.output.csv=true -Dbuildtime.output.csv.file=../data/out.csv
mvn org.owasp:benchmarkutils-maven-plugin:append-time -DtoolName=findbugs

