#!/usr/bin/env bash

if ! command -v docker &> /dev/null
then
  echo "Docker is required. Please install Docker and make sure it is running, and then try again."
  exit 1
fi
