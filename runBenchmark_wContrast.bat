@ECHO OFF
IF EXIST tools\Contrast\contrast.jar (
  IF EXIST tools\Contrast\findings (
        DEL \F \Q tools\Contrast\findings

        RMDIR \S tools\Contrast\working

        ECHO ""

        ECHO Previous Contrast results have been removed

        ECHO ""
    )
    CALL mvn clean package cargo:run -Pdeploywcontrast

    ECHO Copying Contrast reports to results directory

    COPY tools\Contrast\working\contrast.log results\Benchmark_1.2beta-Contrast.log

) ELSE (
    ECHO Given that Contrast is a commercial product, you have to have a licensed version of Contrast in order to run it on the Benchmark. If you have access to Contrast, download the Java 1.5 version of contrast.jar from the Team Server and put it into the /tools/Contrast folder, and then rerun this script.
)