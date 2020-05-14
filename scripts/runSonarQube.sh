status=$(sudo -u root -p password /etc/init.d/sonar status)
if [[ $status != *"SonarQube is running"* ]];then
    echo "SonarQube is not running..."
    echo "Attempting to start service....."
    sudo -u root -p password /etc/init.d/sonar start
fi;
    mvn compile sonar:sonar -Dbuildtime.output.csv=true -Dbuildtime.output.csv.file=classes/out.csv -Dsonar.scm.disabled=true -Dsonar.skipDesign=true -Dsonar.cpd.exclusions=**/*.java -Dsonar.importSources=false -Dsonar.exclusions=**/*.xml
    done=false
    while [ "$done" != "true" ]
    do
      done=$(curl -sb -H "Accept: application/json" http://localhost:9000/api/analysis_reports/is_queue_empty)
    done
    mvn validate -Ptime -Dexec.args="sonar"
