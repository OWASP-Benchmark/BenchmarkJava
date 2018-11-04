mvn compile com.github.spotbugs:spotbugs-maven-plugin:3.1.8:spotbugs -Dbuildtime.output.csv=true -Dbuildtime.output.csv.file=classes/out.csv
mvn validate -Ptime -Dexec.args="spotbugs"
