FROM alpine:latest

RUN apk update && apk add git openjdk8-jre-base-8.181.13-r0 maven-3.3.9-r1

COPY . /root/BenchmarkJava

RUN cd /root/BenchmarkJava && mvn package && git clone https://github.com/OWASP-Benchmark/BenchmarkUtils.git && cd /root/BenchmarkJava/BenchmarkUtils && mvn package

ENTRYPOINT "/root/BenchmarkJava/tools/DongTai/runBenchmark_wDongTai.sh"
