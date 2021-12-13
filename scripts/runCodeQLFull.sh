# The full list of java CodeQL query sets is:
#  tested: java-code-scanning.qls - Standard Code Scanning queries for Java  - This does NOT include Weak Random rule.
#  tested: java-security-extended.qls - Security-extended queries for Java - Same score.
##         this one builds on the previous one a litte
#  tested: java-security-and-quality.qls - Security-and-quality queries for Java - This ONE adds Weak Random rule.
##         this one builds on the previous one. But detects nothing additional - Also does NOT include Weak Random rule.
#  tested: java-lgtm.qls - Standard LGTM queries for Java - scores lower than lgtm-full by 1 category (Random)
#  tested: java-lgtm-full.qls - Standard LGTM queries for Java, including ones not displayed by default - This ONE adds Weak Random rule.

# This script assumes the owasp-benchmark database has already been initialized by running this first:
# ../../Tools/codeql-home/codeql/codeql database create owasp-benchmark --language=java
#../../Tools/codeql-home/codeql/codeql database analyze owasp-benchmark java-security-extended.qls --format=sarifv2.1.0 --output=results/Benchmark_1.2-codeql_java-security-extended.sarif
../../Tools/codeql-home/codeql/codeql database analyze owasp-benchmark java-security-and-quality.qls --format=sarifv2.1.0 --output=results/Benchmark_1.2-codeql_java-security-and-quality.sarif

