# OWASP Benchmark
The OWASP Benchmark Project is a Java test suite designed to verify the speed and accuracy of vulnerability detection tools. The initial version is intended to support Static Analysis Security Testing Tools (SAST). A future release will support Dynamic Analysis Security Testing Tools (DAST), like <a href="https://www.owasp.org/index.php/ZAP">OWASP ZAP</a>, and Interactive Analysis Security Testing Tools (IAST). The goal is that this test application is fully runnable and all the vulnerabilities are actually exploitable so its a fair test for any kind of application vulnerability detection tool.

The project documentation is all on the OWASP site at the <a href="https://www.owasp.org/index.php/Benchmark">OWASP Benchmark</a> project pages. Please refer to that site for all the project details.

# Docker
A ready to run `docker` image is available at `andresriancho/owasp-benchmark`:

```bash
docker run --rm -it -p 8443:8443 andresriancho/owasp-benchmark
```

It is possible to build and run your own `docker` image by running:

```bash
docker build -t owasp-benchmark .
docker run --rm -it -p 8443:8443 owasp-benchmark
```