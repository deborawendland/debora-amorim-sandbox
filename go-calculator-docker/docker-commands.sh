#!/bin/bash

start_microservice () {
  docker run -p 8080:8080 -d --name calc calc
}

stop_microservice () {
  docker stop calc
}

status_microservice() {
  if [ "$(docker ps | grep calc)" ]
  then
      echo RUNNING
  else
      echo NOT RUNNING
  fi
}

"$@"