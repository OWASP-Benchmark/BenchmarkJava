@ECHO OFF
IF EXIST .\secagent.jar (
  IF EXIST .\working (

        RMDIR /S /Q .\working

        ECHO.
        ECHO Previous results have been removed
        ECHO.
    )

    CD ..\..

    ECHO After Crawl is Complete, hit Ctrl-C to stop Benchmark Tomcat instance.
    ECHO When it asks "Terminate batch job (Y/N)?" Enter N, so script will complete and copy results to /results directory.
    ECHO.

    CALL mvn clean package cargo:run -Pdeploywhcl

    ECHO Copying HCL reports to results directory

    COPY tools\HCL\working\HCL-IAST.hcl results\Benchmark_HCL-IAST.hcl

    CD tools\HCL

) ELSE (
    ECHO HCL is a commercial product, so you need a licensed version of HCL in order to run it on the Benchmark. If you have access to HCL, download the HCL Agent for Java ^(secagent.jar^), put it into the /tools/HCL folder, and then rerun this script. Please contact HCL at https://www.hcl.com/.
)
