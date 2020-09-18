#!/bin/bash

dirname=$(basename "$PWD")

if [[ "$dirname" == "VMs" ]]; then
  # running script from VMs subdir, go to project root
  #   for docker context
  cd ..
fi
docker build -t benchmark:latest -f VMs/Dockerfile .
