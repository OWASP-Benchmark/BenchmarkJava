#!/bin/sh

docker run -t -i -p 8443:8443 --name bench --rm benchmark ./runRemoteAccessibleBenchmark.sh
