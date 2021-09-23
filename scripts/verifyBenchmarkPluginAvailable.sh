# Verify the benchmarkutils plugin is installed. And if not, explain how to install it
mvn -Djava.awt.headless=true -Dplugin=org.owasp:benchmarkutils-maven-plugin help:describe 2>&1 >/dev/null

if [ $? -ne 0 ]
then
  echo ""
  echo "!!!WARNING: Required plugin: org.owasp:benchmarkutils-maven-plugin not available."
  echo "To get and install it, do the following:"
  echo "  git clone https://github.com/OWASP-Benchmark/BenchmarkUtils.git"
  echo "  cd BenchmarkUtils"
  echo "  mvn install"
  echo ""
  echo "This installs the plugin in your local Maven repo, and it can then be used from anywhere."
  echo ""
  exit -1
fi

