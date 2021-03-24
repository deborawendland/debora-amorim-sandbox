#!/bin/bash

start_microservice () {
  docker run -p 8080:8080 -d deborawendland/calculator-app:latest
}

stop_microservice () {
  docker stop calc
}

status_microservice() {
  if [ "$(docker ps | grep deborawendland/calculator-app)" ]
  then
      echo RUNNING
  else
      echo NOT RUNNING
  fi
}

"$@"