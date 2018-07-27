echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
docker push statnlp/service-negationscope
docker push statnlp/service-negationscope:0.0.0
