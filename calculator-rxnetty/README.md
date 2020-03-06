# Calculator using Karyon and Docker
HomeWork 08 - Cloud Native

### CALCULATOR - DEPLOYMENT
1. To deploy the application, access its root project folder and execute: `./gradlew fatJar`

### DOCKER
2. In order to build calculator's image on docker, it's necessary to access the Tema-06 or Calculator's root directory (where Dockerfile is located) and then run: 
`docker build -t calculator .`
3. Since the image is built, run: `sudo docker run -p 8080:8080 calculator`
4. Now, all you need to do is start the server and access [localhost:8080/](http://localhost:8080/) 
5. To exit, just press `CTRL + C`

### CALCULATOR WEBAPP 
* The math operations supported by the calculator are:
  * sum
  * sub
  * mul
  * div
  * exp
* To execute an operation, follow the pattern below:
  * Example a: 9/3
  * `localhost:8080/div/9/3` 
  * Example b: 6-7-8
  * `localhost:8080/sub/6/7/8` 
* To access calculator logs, just enter:
  * `localhost:8080/logs` 
