# This dockerfile builds a container that pulls down and runs the latest version of BenchmarkJava
FROM ubuntu:22.04
LABEL org.opencontainers.image.authors="Dave Wichers dave.wichers@owasp.org"

RUN apt-get update \
    && DEBIAN_FRONTEND="noninteractive" apt-get -y install tzdata \
    && apt-get install -q -y \
       openjdk-17-jre-headless \
       openjdk-17-jdk \
       git \
       maven \
       wget \
       iputils-ping \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

RUN mkdir /owasp
WORKDIR /owasp

# Download, build, install Benchmark Utilities required by crawler and scorecard generation
RUN git clone https://github.com/OWASP-Benchmark/BenchmarkUtils.git \
    && cd BenchmarkUtils \
    && mvn install

# Download, build BenchmarkJava
RUN git clone https://github.com/OWASP-Benchmark/BenchmarkJava \
    && git config --global --add safe.directory /owasp/BenchmarkJava \
    && cd BenchmarkJava \
    && mvn clean package cargo:install

RUN useradd -d /home/bench -m -s /bin/bash bench \
    && echo bench:bench | chpasswd

RUN chown -R bench /owasp/
ENV PATH=/owasp/BenchmarkJava:$PATH

# Start up Benchmark once for 60 seconds then kill it, so additional runtime
# dependencies are downloaded and cached in the image.
# exit 0 prevents the timeout return code from failing the Docker build.
WORKDIR /owasp/BenchmarkJava
RUN timeout 60 ./runBenchmark.sh; exit 0

EXPOSE 8443
CMD ["./runBenchmark.sh"]

