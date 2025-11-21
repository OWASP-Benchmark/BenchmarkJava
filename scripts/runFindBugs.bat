# source "scripts/verifyBenchmarkPluginAvailable.sh" - Don't have .bat version of this (yet)

# FindBugs is dead, so this specifies the specific (last) version of findbugs. Its version is not defined in the pom.xml file.
# The buildtime elements when invoking the findbugs-maven-plugin leverage the buildtime extension specified in: .mvn/extensions.xml
call mvn compile org.codehaus.mojo:findbugs-maven-plugin:3.0.5:findbugs -Dbuildtime.output.csv=true -Dbuildtime.output.csv.file=../data/out.csv
call mvn org.owasp:benchmarkutils-maven-plugin:append-time -DtoolName=findbugs

