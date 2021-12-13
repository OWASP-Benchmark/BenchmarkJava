# This script assumes the owasp-benchmark database has already been initialized by running this first:
# ../../Tools/codeql-home/codeql/codeql database create owasp-benchmark --language=java
../../Tools/codeql-home/codeql/codeql database analyze owasp-benchmark java-code-scanning.qls --format=sarifv2.1.0 --output=results/Benchmark_1.2-codeql_java-code-scanning_qls.sarif

