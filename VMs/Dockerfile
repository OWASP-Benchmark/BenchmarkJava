# This dockerfile builds a container that pulls down and runs the latest version of Benchmark
FROM ubuntu:15.04
MAINTAINER Simon Bennetts "psiinon@gmail.com"

RUN apt-get update && apt-get clean
RUN apt-get install -q -y make automake autoconf gcc g++ openjdk-7-jre-headless openjdk-7-jdk ruby wget curl xmlstarlet unzip git x11vnc xvfb openbox xterm net-tools ruby-dev && apt-get clean
RUN apt-get --assume-yes --fix-missing install python-pip x11vnc 

RUN mkdir /benchmark
WORKDIR /benchmark
RUN wget http://archive.apache.org/dist/maven/maven-3/3.2.3/binaries/apache-maven-3.2.3-bin.tar.gz
RUN tar -xzf apache-maven-3.2.3-bin.tar.gz
RUN cp -R apache-maven-3.2.3 /usr/local
RUN ln -s /usr/local/apache-maven-3.2.3/bin/mvn /usr/bin/mvn

ENV bench /benchmark/bench.sh
RUN echo "#!/bin/sh" > ${bench}
RUN echo "git clone https://github.com/OWASP/benchmark" >> ${bench}
RUN echo "cd benchmark" >> ${bench}
RUN echo "chmod +x runRemoteAccessibleBenchmark.sh" >> ${bench}
RUN echo "./runRemoteAccessibleBenchmark.sh" >> ${bench}
RUN chmod a+x ${bench}

RUN useradd -d /home/bench -m -s /bin/bash bench 
RUN echo bench:bench | chpasswd

RUN chown -R bench /benchmark/
ENV PATH /benchmark/benchmark/:$PATH

CMD ["/benchmark/bench.sh"]

