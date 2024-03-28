# The full list of java CodeQL query sets is:
#  tested: java-code-scanning.qls - Standard Code Scanning queries for Java  - This does NOT include Weak Random rule.
#  tested: java-security-extended.qls - Adds a bunch of rules to previous ruleset.
#  tested: java-security-and-quality.qls - Adds a bunch of other rules, but scores identical to security-extended ruleset.
#  tested: java-lgtm.qls - Standard LGTM queries for Java - scores the same as standard java-code-scanning.qls
#  tested: java-lgtm-full.qls - Standard LGTM queries for Java, including ones not displayed by default. Scores the same as security-extended ruleset.

# This script assumes the owasp-benchmark database has already been initialized by running this first:
# ../../Tools/codeql-home/codeql/codeql database create owasp-benchmark --language=java
#../../Tools/codeql-home/codeql/codeql database analyze owasp-benchmark java-security-extended.qls --format=sarifv2.1.0 --output=results/Benchmark_1.2-codeql_java-security-extended.sarif
benchmark_version=$(scripts/getBenchmarkVersion.sh)
../../Tools/codeql-home/codeql/codeql database analyze owasp-benchmark java-security-and-quality.qls --format=sarifv2.1.0 --output=results/Benchmark_$benchmark_version-codeql_java-security-and-quality.sarif

