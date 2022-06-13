# This dockerfile builds a container that pulls down and runs the latest version of Benchmark
FROM ubuntu:latest
MAINTAINER "Dave Wichers dave.wichers@owasp.org"

RUN apt-get update
RUN DEBIAN_FRONTEND="noninteractive" apt-get -y install tzdata
RUN apt-get install -q -y \
     openjdk-8-jre-headless \
     openjdk-8-jdk \
     git \
     maven \
     wget \
     iputils-ping \
     && apt-get clean

RUN mkdir /owasp
WORKDIR /owasp

# Download, build, install Benchmark Utilities required by crawler and scorecard generation
RUN git clone https://github.com/OWASP-Benchmark/BenchmarkUtils.git
WORKDIR /owasp/BenchmarkUtils
RUN mvn install

# Download, build BenchmarkJava
WORKDIR /owasp
RUN git clone https://github.com/OWASP-Benchmark/BenchmarkJava

# Workaround for security fix for CVE-2022-24765
RUN git config --global --add safe.directory /owasp/BenchmarkJava

WORKDIR /owasp/BenchmarkJava
RUN mvn clean package cargo:install

RUN useradd -d /home/bench -m -s /bin/bash bench 
RUN echo bench:bench | chpasswd

RUN chown -R bench /owasp/
ENV PATH /owasp/BenchmarkJava:$PATH

# start up Benchmark once, for 60 seconds, then kill it, so the additional dependencies required to run it are downloaded/cached in the image as well.
# exit 0 is required to return a 'success' code, otherwise the timeout returns a failure code, causing the Docker build to fail.
WORKDIR /owasp/BenchmarkJava
RUN timeout 60 ./runBenchmark.sh; exit 0

