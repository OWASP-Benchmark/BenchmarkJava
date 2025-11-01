# OWASP Benchmark for Java
The OWASP Benchmark Project is a Java test suite designed to verify the speed and accuracy of vulnerability detection tools. It is a fully runnable open source web application that can be analyzed by any type of Application Security Testing (AST) tool, including SAST, DAST (like <a href="https://www.zaproxy.org/">ZAP</a>), and IAST tools. The intent is that all the vulnerabilities deliberately included in and scored by the Benchmark are actually exploitable so it's a fair test for any kind of application vulnerability detection tool.

The Benchmark project also includes scorecard generators for numerous open source and commercial AST tools, and the set of supported tools is growing all the time. This scoring capability is implemented in the BenchmarkUtils project, which is at: https://github.com/OWASP/BenchmarkUtils.

The project documentation is all on the OWASP site at the <a href="https://owasp.org/www-project-benchmark">OWASP Benchmark</a> project pages. Please refer to that site for all the project details.

The current latest release is v1.2. Note that all the releases that are available here: https://github.com/OWASP/BenchmarkJava/releases, are historical. The latest release is always available live by simply cloning or pulling the head of this repository (i.e., git pull).

Running Benchmark Itself:
* runBenchmark.sh - run the Benchmark Web Application (accessible via local machine only)
* runRemoteAccessibleBenchmark.sh - like the above but allows port 8443 to be accessible outside the machine Benchmark is running on.
