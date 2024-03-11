@ECHO OFF
IF EXIST .\secagent.jar (
  IF EXIST ..\..\results\HCL-IAST.hcl (

        DEL ..\..\results\HCL-IAST.hcl

        ECHO.
        ECHO Previous results have been removed
        ECHO.
    )

    CD ..\..

    CALL mvn clean package cargo:run -Pdeploywhcl -Drunenv=remote

) ELSE (
    ECHO HCL is a commercial product, so you need a licensed version of HCL in order to run it on the Benchmark. If you have access to HCL, download the HCL Agent for Java ^(secagent.jar^), put it into the /tools/HCL folder, and then rerun this script. Please contact HCL at https://www.hcl.com/.
)
