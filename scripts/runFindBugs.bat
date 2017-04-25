call mvn compile findbugs:findbugs -Dbuildtime.output.csv=true -Dbuildtime.output.csv.file=classes\out.csv
call mvn validate -Ptime -Dexec.args="findbugs"
