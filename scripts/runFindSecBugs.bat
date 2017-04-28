call mvn compile -Pfindsecbugs -Dbuildtime.output.csv=true -Dbuildtime.output.csv.file=classes\out.csv
call mvn validate -Ptime -Dexec.args="findsecbugs"