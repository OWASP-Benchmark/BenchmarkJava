#!/usr/bin/env bash

# Downloads a ZAP XML report from a URL and saves it to the results/ directory.
# After downloading, run createScorecards.sh to generate the scorecard.
#
# Usage: scripts/fetchZAPResults.sh <ZAP_REPORT_URL> [OUTPUT_FILENAME]
#
# Examples:
#   scripts/fetchZAPResults.sh http://172.17.0.3:8090/OTHER/core/other/xmlreport/
#   scripts/fetchZAPResults.sh "http://zap:8090/OTHER/core/other/xmlreport/?apikey=abc123"
#   scripts/fetchZAPResults.sh http://zap:8090/OTHER/core/other/xmlreport/ my-zap-results.xml

source scripts/requireCommand.sh

requireCommand curl

if [ $# -eq 0 ]; then
    echo "Usage: $0 <ZAP_REPORT_URL> [OUTPUT_FILENAME]"
    echo ""
    echo "Downloads a ZAP XML report from the given URL and saves it to results/."
    echo "After downloading, run createScorecards.sh to generate the scorecard."
    echo ""
    echo "Examples:"
    echo "  $0 http://172.17.0.3:8090/OTHER/core/other/xmlreport/"
    echo "  $0 \"http://zap:8090/OTHER/core/other/xmlreport/?apikey=abc123\""
    echo "  $0 http://zap:8090/OTHER/core/other/xmlreport/ my-zap-results.xml"
    exit 1
fi

zap_url="$1"

if [ $# -ge 2 ]; then
    filename="$2"
else
    benchmark_version=$(scripts/getBenchmarkVersion.sh)
    date_stamp=$(date +%Y%m%d)
    filename="Benchmark_${benchmark_version}-ZAP-${date_stamp}.xml"
fi

output="results/${filename}"

echo "Downloading ZAP report from: ${zap_url}"
http_code=$(curl -sS -o "${output}" -w '%{http_code}' --connect-timeout 10 --max-time 120 "${zap_url}")

if [ "${http_code}" -ne 200 ]; then
    echo "ERROR: Download failed with HTTP status ${http_code}"
    rm -f "${output}"
    exit 1
fi

if ! head -2 "${output}" | grep -q "OWASPZAPReport"; then
    echo "ERROR: Downloaded file does not appear to be a ZAP XML report."
    echo "First 3 lines of downloaded content:"
    head -3 "${output}"
    rm -f "${output}"
    exit 1
fi

echo "ZAP report saved to: ${output}"
echo "To generate the scorecard, run: ./createScorecards.sh"
