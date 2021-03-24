Packer Homework
===============

1. Create a packer config file for backing a docker image of your go microservice.

#### Installation
- Docker:
    - `sudo apt install docker.io`
- Packer:
    - `sudo apt install packer`
    
#### Packer
Please be sure Packer version is above `v1.6`.  
To build the docker image, we will be using Packer, follow the command below:
- `packer build packer-docker.json`

#### docker-commands.sh
The docker-commands script contains 3 functions:
- start_microservice
- stop_microservice
- status_microservice

To run the script:
- `bash docker-commands.sh <start_microservice|stop_microservice|status_microservice>`

#### Docker
You'll run the image as:
- `docker run -p 8080:8080 -d deborawendland/calculator-app`

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