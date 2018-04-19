#!/usr/bin/env bash

for num in {0..1100}
do
  curl localhost:8080/connect-hang?index=$num &
done
