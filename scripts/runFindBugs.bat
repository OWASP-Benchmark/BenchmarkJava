# FindBugs is dead, so this specifies the specific (last) version of findbugs. Its version is not defined in the pom.xml file.
call mvn compile org.codehaus.mojo:findbugs-maven-plugin:3.0.5:findbugs -Dbuildtime.output.csv=true -Dbuildtime.output.csv.file=classes/out.csv
call mvn validate -Ptime -Dexec.args="findbugs"
