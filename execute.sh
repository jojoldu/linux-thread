#!/usr/bin/env bash

/home/ec2-user/gradlew clean build

nohup java -jar /home/ec2-user/linux-thread/build/libs/linux-thread-0.0.1-SNAPSHOT.jar &