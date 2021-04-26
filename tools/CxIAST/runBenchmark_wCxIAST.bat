@ECHO OFF
IF EXIST .\cx-launcher.jar (
  IF EXIST .\iast_cache (
      rmdir /q /s .\iast_cache

      IF EXIST .\logs (
        rmdir /q /s .\logs
      )

      ECHO.
      ECHO Previous Checkmarx IAST results have been removed
      ECHO.
  )
    CD ..\..

    CALL mvn clean package cargo:run -Pdeploywcxiast

    CD tools\CxIAST

) ELSE (
    ECHO Checkmarx IAST is a commercial product, so you need a licensed version of Checkmarx IAST in order to run it on the Benchmark. If you have access to Checkmarx IAST and want to run the Benchmark against it you will have to:
    ECHO   *  download the CxIAST Agent for Java ^(cxiast-java-agent.zip^) from the Server;
    ECHO   *  put it into the /tools/CxIAST folder;
    ECHO   *  unzip it; and then
    ECHO   *  rerun this script.
)
