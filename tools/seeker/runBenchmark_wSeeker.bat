@ECHO OFF
IF EXIST .\seeker-agent.jar (
  
    CD ..\..

    CALL mvn clean package cargo:run -Pdeploywseeker

    CD tools\Seeker

) ELSE (
    ECHO Seeker is a commercial product, so you need a licensed version of Seeker in order to run it on the Benchmark.
    ECHO   *  download the CxIAST Agent for Java ^(cxiast-java-agent.zip^) from the Server;
    ECHO   *  put it into the /tools/CxIAST folder;
    ECHO   *  unzip it;
    ECHO   *  update pom.xml ^(deploywseeker section, seeker.server.url^); and then
    ECHO   *  rerun this script.
)
