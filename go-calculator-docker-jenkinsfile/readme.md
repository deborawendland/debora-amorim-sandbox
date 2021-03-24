Homework Jenkins
================

1. Create a 2 PIPELINEs for your GO Microservice  
   1.1 First pipeline will be caled BAKE and you will need use PACKER and bake a docker image  
   1.2 Second pipeline will be called LAUNCH and you will DEPLOY you microservice in DOCKER  

#### Installation
- Jenkins:
    - `wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo apt-key add -`
    - `deb https://pkg.jenkins.io/debian-stable binary/`
    - `sudo apt-get update`
    - `sudo apt-get install jenkins`
    - `sudo /etc/init.d/jenkins start`
- Docker:
    - `sudo apt install docker.io`
- Packer:
    - `sudo apt install packer`
    
#### Jenkins
- Pipeline BAKE:
    - First you need to set your GitHub credentials:
        - `Manage Jenkins > Manage Credentials > Global > Add Credentials > Username with Password`
        - Set your ID to `Git`, otherwise change the Jenkinsfile script on `Git credentialsId: '{yourID}'`.
    - Go to Jenkins Home and add a new job:
        - Select **pipeline**, name it **Bake**;
        - On **Pipeline > Pipeline Script** copy and paste the content of `bake/Jenkinsfile`.
        - You are ready to build!
- Pipeline LAUNCH:
    - Go to Jenkins Home and add a new job:
        - Select **pipeline**, name it **Launch**;
        - On **Pipeline > Pipeline Script** copy and paste the content of `launch/Jenkinsfile`.
        - You are ready to build!

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