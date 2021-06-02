@ECHO OFF
IF EXIST .\contrast.jar (
  IF EXIST .\working (
        DEL \F \Q .\working\contrast.log

        RMDIR \S .\working\cache

        ECHO ""

        ECHO Previous Contrast results have been removed

        ECHO ""
    )

    CD ..\..

    CALL mvn clean package cargo:run -Pdeploywcontrast

    ECHO Copying Contrast reports to results directory

    COPY tools\Contrast\working\contrast.log results\Benchmark_1.2-Contrast.log

    CD tools\Contrast

) ELSE (
    ECHO Contrast is a commercial product, so you need a licensed version of Contrast in order to run it on the Benchmark. If you have access to Contrast, download the Contrast Agent for Java (contrast.jar^) from the Team Server and put it into the /tools/Contrast folder, and then rerun this script. If you don't have access to Contrast, you can likely use the free Contrast Community Edition on Benchmark. See: https://www.contrastsecurity.com/community-edition-lp
)
