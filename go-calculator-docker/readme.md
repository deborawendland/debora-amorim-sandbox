Docker Homework
===============

1. Create a Dockerfile for your go microservice
2. Create a BASH script that runs your microservice and stop it show the status - we should use functions. ie:
   startMicroservice()
   stopMicroservice()
   statusMicroservice() = RUNNING | NOT RUNING
   

#### docker-commands.sh
The docker-commands script contains 3 functions:
- start_microservice
- stop_microservice
- status_microservice

To run the script:
- `bash docker-commands.sh <start_microservice|stop_microservice|status_microservice>`

#### Docker
In order to run, you need to build the docker image: 
- `docker build -t calc .`

Then you'll run the image as:
- `docker run -p 8080:8080 -d --name calc calc`

To stop the container, you can enter:
- `docker stop calc`


#### Application
You can access your application on: 
- `http://localhost:8080/calc/{operation}/{firstTerm}/{secondTerm}`

Examples:
- Sum: `http://localhost:8080/calc/sum/3/4`
- Sub: `http://localhost:8080/calc/sub/5/-2`
- Mul: `http://localhost:8080/calc/mul/3/3`
- Div: `http://localhost:8080/calc/div/9/4.5`
- History: `http://localhost:8080/calc/history`