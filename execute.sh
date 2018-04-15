#!/usr/bin/env bash

CURRENT_PID=$(pgrep -f linux-thread)
kill -9 $CURRENT_PID

/home/ec2-user/linux-thread/gradlew clean build

nohup java -jar /home/ec2-user/linux-thread/build/libs/linux-thread-0.0.1-SNAPSHOT.jar &

echo $(pgrep -f linux-thread)
