FROM maven:3-jdk-7

COPY . /benchmark
WORKDIR /benchmark

ENV bench /benchmark/bench.sh
RUN echo "#!/bin/sh" > ${bench}
RUN echo "cd benchmark" >> ${bench}
RUN echo "chmod +x runRemoteAccessibleBenchmark.sh" >> ${bench}
RUN echo "./runRemoteAccessibleBenchmark.sh" >> ${bench}
RUN chmod a+x ${bench}

RUN useradd -d /home/bench -m -s /bin/bash bench 
RUN echo bench:bench | chpasswd

RUN chown -R bench /benchmark/
ENV PATH /benchmark/benchmark/:$PATH

CMD ["/benchmark/bench.sh"]
