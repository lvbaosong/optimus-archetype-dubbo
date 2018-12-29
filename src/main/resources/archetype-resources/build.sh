#!/bin/bash
cd `dirname $0`

###### const definition
img_mvn="maven:3.3.3-jdk-8"                 # docker image of maven
m2_cache=~/.m2                              # the local maven cache dir
proj_home=$PWD                              # the project root dir

###### step1
git pull  # should use git clone https://name:pwd@xxx.git

###### step2 build project
echo "use docker maven"
docker run --rm \
   -v $m2_cache:/root/.m2 \
   -v $proj_home:/usr/src/mymaven \
   -w /usr/src/mymaven $img_mvn mvn clean package -U

###### step3 build image
sudo mv $proj_home/${rootArtifactId}-provider/target/${rootArtifactId}-provider-*.jar $proj_home/demo.jar