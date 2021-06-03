# Generates results files in the folder reports/. The ShiftLeftScanReader processes the file: reports/scan-full-report.json
docker run --rm -e "WORKSPACE=${PWD}" -v ~/.m2:/.m2 -v ${PWD}:/app shiftleft/scan scan --src /app --type java

