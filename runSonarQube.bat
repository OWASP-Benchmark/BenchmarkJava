call mvn compile sonar:sonar -Dbuildtime.output.csv=true -Dbuildtime.output.csv.file=classes\out.csv -Dsonar.scm.disabled=true -Dsonar.skipDesign=true -Dsonar.cpd.exclusions=**/*.java -Dsonar.importSources=false -Dsonar.exclusions=**/*.xml
call mvn validate -Ptime -Dexec.args="sonar"
