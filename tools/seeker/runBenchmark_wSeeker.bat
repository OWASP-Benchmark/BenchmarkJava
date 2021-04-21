@ECHO OFF
IF EXIST .\seeker-agent.jar (
  
    CD ..\..

    CALL mvn clean package cargo:run -Pdeploywseeker

    CD tools\seeker

) ELSE (
    ECHO Seeker is a commercial product, so you need a licensed version of Seeker in order to run it on the Benchmark.
    ECHO   *  download the Seeker Agent for Java ^(Seeker-java-agent.zip^) from the Server;
    ECHO   *  put it into the /tools/seeker folder;
    ECHO   *  unzip it;
    ECHO   *  update pom.xml ^(deploywseeker section, seeker.server.url^); and then
    ECHO   *  rerun this script.
)
