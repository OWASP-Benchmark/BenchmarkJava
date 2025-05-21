# First, you have to get the platform binaries from: https://github.com/github/codeql-cli-binaries/releases
# And then install them in a tools directory, that is a peer to your HOME_FOLDER. HOME_FOLDER should contain BenchmarkJava, BenchmarkUtils, etc.
# The unzipped codeql-binaries codeql/ folder should be put in tools/codeql-home/
# NOTE: This tool requires Java 11+

# You have to download the rulepacks now. This does this.
../../tools/codeql-home/codeql/codeql pack download codeql/java-queries

# This translates the current app, and builds up the rules databases. This only has to be run once after each code change.
../../tools/codeql-home/codeql/codeql database create owasp-benchmark --language=java --overwrite --command="mvn clean package"

