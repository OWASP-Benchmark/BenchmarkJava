@ECHO OFF
IF EXIST .\secagent.jar (
  IF EXIST .\working (
        DEL /F /Q .\working\*.*

        RMDIR /S /Q .\working\cache

        ECHO ""

        ECHO Previous results have been removed

        ECHO ""
    )

    CD ..\..

    CALL mvn clean package cargo:run -Pdeploywhcl

    ECHO Copying reports to results directory

    COPY tools\HCL\working\HCL-IAST.hcl results\HCL-IAST.hcl

    CD tools\HCL

) 
