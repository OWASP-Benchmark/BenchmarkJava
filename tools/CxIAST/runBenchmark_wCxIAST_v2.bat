@ECHO OFF

IF EXIST .\CxIAST.bat (
  
	IF EXIST .\iast_cache (
      rmdir /q /s .\iast_cache
	 
      ECHO Previous Checkmarx CxIAST results have been removed
	  )
  
	ECHO Starting Checkmarx CxIAST Agent on Benchmark
    CxIAST.bat -e ..\..\RunBenchmark.bat

) ELSE (
    ECHO Checkmarx CxIAST is a commercial product, so you need a licensed version of Checkmarx CxIAST in order to run it on the Benchmark. If you have access to Checkmarx CxIAST and want to run the Benchmark against it you will have to:
    ECHO   *  download the CxIAST Agent for Java ^(cxiast-java-agent.zip^) from the Server;
    ECHO   *  put it into the /tools/CxIAST folder;
    ECHO   *  unzip it; and then
    ECHO   *  rerun this script.
)
