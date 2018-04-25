# This dockerfile builds a container that pulls down and runs the latest version of Benchmark
FROM ubuntu:16.04
MAINTAINER Simon Bennetts "psiinon@gmail.com"

RUN apt-get update && apt-get clean
RUN apt-get install -q -y \
     make \
     automake \
     autoconf \
     gcc \
     g++ \
     openjdk-8-jre-headless \
     openjdk-8-jdk \
     ruby \
     curl \
     xmlstarlet \
     git \
     x11vnc \
     xvfb \
     openbox \
     xterm \
     net-tools \
     ruby-dev \
     maven \
     && apt-get clean

RUN apt-get --assume-yes --fix-missing install python-pip x11vnc 

RUN mkdir /benchmark
WORKDIR /benchmark

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

