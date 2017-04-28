mvn compile pmd:pmd -Dbuildtime.output.csv=true -Dbuildtime.output.csv.file=classes/out.csv
mvn validate -Ptime -Dexec.args="pmd"