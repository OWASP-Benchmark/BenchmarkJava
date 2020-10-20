@ECHO OFF
IF EXIST .\secpoint.jar (
  IF EXIST .\working (
        DEL \F \Q .\secpoint.log

        DEL \F \Q .\secpoint.properties

        RMDIR \S ..\..\results\security.sec

        ECHO ""

        ECHO Previous secpoint results have been removed

        ECHO ""
    )

    CD ..\..

    CALL mvn clean package cargo:run -Pdeploywsecpoint

    CD tools\secpoint

) ELSE (
    ECHO Secpoint is a commercial product, so you need a licensed version of Secpoint in order to run it on the Benchmark. If you have access to Contrast, download the Secpoint Agent for Java (secpoint.jar) from the Team Server and put it into the /tools/Secpoint folder, and then rerun this script. If you don't have a license for Secpoint, you can probably use the free Secpoint Community Edition (CE) on Benchmark. See: https://www.tcsec.com.cn/
)
