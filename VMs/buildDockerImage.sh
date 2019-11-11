# Pull in latest version of ubuntu
docker pull ubuntu:latest
# Remove any ubuntu:<none> image if it was left behind by a new version of ubunto:latest being pulled
i=$(docker images | grep "ubuntu" | grep "<none" | awk '{print $3}')
if [ "$i" ]
then
  docker rmi $i
fi

# Since Docker doesn't auto delete anything, just like for the Ubunto update, delete any existing benchmark:latest image before building a new one
docker image rm benchmark:latest
docker build -t benchmark .

