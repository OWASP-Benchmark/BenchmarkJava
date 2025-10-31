#!/usr/bin/env bash

# Check for install/updates at https://github.com/bearer/bearer

# For this script to work, you need to change the permissions on the results/ directory to 777
# so docker can write the results file into the results/ folder

source scripts/requireCommand.sh

requireCommand docker

docker pull bearer/bearer --platform linux/amd64

benchmark_version=$(scripts/getBenchmarkVersion.sh)
bearer_version=$(docker run --platform linux/amd64 bearer/bearer bearer --version | grep -o '[[:digit:]]\+\.[[:digit:]]\+\.[[:digit:]]\+')
result_file="results/Benchmark_$benchmark_version-Bearer-v$bearer_version.json"
temp_result_file="$result_file.tmp"
docker_result_file="/benchmark/$temp_result_file"

# if you set the Docker userid to match the current user id with: --user $(id -u):$(id -g) you get a suspicious git repository error
docker run --platform linux/amd64 --rm -v "${PWD}:/benchmark" bearer/bearer scan /benchmark/src/main/ --format jsonv2 --output "$docker_result_file" > /dev/null

# Because the docker userid and current user ID might be different, we write the Bearer result to a temp file.
# Then copy it to the desired file name, and then delete the temp file.
#
# We can't just chown the file to the right user ID as Unix won't allow that.
cp $temp_result_file $result_file
rm -f $temp_result_file

