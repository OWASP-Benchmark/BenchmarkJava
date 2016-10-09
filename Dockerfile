FROM maven:3-jdk-7

ENV workdir=/benchmark \
    bench=${workdir}/bench.sh \
    PATH=/benchmark/benchmark/:$PATH

COPY . ${workdir}
WORKDIR ${workdir}

RUN echo "chmod +x runRemoteAccessibleBenchmark.sh" >> ${bench}
RUN echo "./runRemoteAccessibleBenchmark.sh" >> ${bench}
RUN chmod a+x ${bench}
RUN useradd -d /home/bench -m -s /bin/bash bench 
RUN echo bench:bench | chpasswd
RUN chown -R bench ${workdir}/

CMD ["${bench}"]
