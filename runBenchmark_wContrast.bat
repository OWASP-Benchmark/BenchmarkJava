@ECHO OFF
IF EXIST tools\Contrast\contrast.jar (
  IF EXIST tools\Contrast\working (
        DEL \F \Q tools\Contrast\contrast.log

        RMDIR \S tools\Contrast\cache

        ECHO ""

        ECHO Previous Contrast results have been removed

        ECHO ""
    )
    CALL mvn clean package cargo:run -Pdeploywcontrast

    ECHO Copying Contrast reports to results directory

    COPY tools\Contrast\working\contrast.log results\Benchmark_1.2-Contrast.log

) ELSE (
    ECHO Contrast is a commercial product, so you need a licensed version of Contrast in order to run it on the Benchmark. If you have access to Contrast, download the Contrast Agent for Java (contrast.jar^) from the Team Server and put it into the /tools/Contrast folder, and then rerun this script.
)
