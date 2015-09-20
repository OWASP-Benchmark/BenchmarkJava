call mvn compile sonar:sonar -Dbuildtime.output.csv=true -Dbuildtime.output.csv.file=classes\out.csv -Dsonar.scm.disabled=true -Dsonar.skipDesign=true -Dsonar.cpd.exclusions=**/*.java -Dsonar.importSources=false -Dsonar.exclusions=**/*.xml
@Echo off
:DoUntil
for /f %%i in ('SonarQubeRequest.exe') do set done=%%i
IF NOT %done%==true GOTO DoUntil
:EndDoUntil
call mvn validate -Ptime -Dexec.args="sonar"