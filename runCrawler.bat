@echo off
REM source "scripts/verifyBenchmarkPluginAvailable.sh" - Don't have .bat version of this (yet)
set /A args_count=0    
for %%A in (%*) do set /A args_count+=1
if %args_count% NEQ 0 (
    if %args_count% EQU 2 (
        CALL mvn org.owasp:benchmarkutils-maven-plugin:run-crawler -DcrawlerFile=data/benchmark-crawler-http.xml -DproxyHost="%1" -DproxyPort="%2"
    ) else (
        echo Error!!
        echo -------
        echo To run the Crawler for localhost, execute runCrawler.bat with no arguments.
        echo To run the Crawler for remote host, execute runCrawler.bat with only 2 arguments, proxy-host and proxy-port.
        echo Example: runCrawler.bat 192.168.0.1 53452
    )
) else (
    CALL mvn org.owasp:benchmarkutils-maven-plugin:run-crawler -DcrawlerFile=data/benchmark-crawler-http.xml
)
