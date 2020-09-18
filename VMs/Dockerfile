# This dockerfile builds a container that pulls down and runs the latest version of Benchmark
FROM ubuntu:latest
MAINTAINER "Dave Wichers dave.wichers@owasp.org"

RUN apt-get update
RUN DEBIAN_FRONTEND="noninteractive" apt-get -y install tzdata
RUN apt-get install -q -y \
    openjdk-8-jre-headless \
    openjdk-8-jdk \
    maven \
    wget \
    iputils-ping \
    && apt-get clean

ADD . /owasp/benchmark
WORKDIR /owasp/benchmark
RUN mvn clean package cargo:install

RUN useradd -d /home/bench -m -s /bin/bash bench
RUN echo bench:bench | chpasswd

RUN chown -R bench /owasp/
ENV PATH /owasp/benchmark/:$PATH

