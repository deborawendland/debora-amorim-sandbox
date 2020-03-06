# GitHub and Twitter Microsservices Integration using SpringBoot, Rest, and Docker
HomeWork 07 - Cloud Native

### Twitter - DEPLOYMENT & DOCKER
1. To deploy the application, access its root project folder and execute: `./gradlew bootJar`
2. In order to build twitter's image on docker, it's necessary to access the Tema-07/microservice-twitter or Twitter's root directory (where Dockerfile is located) and then run: 
`docker build -t twitter .`
3. Since the image is built, run: `sudo docker run -p 8082:8082 -d twitter`
4. Now, all you need to do is start the server and access [localhost:8082/{user}/](http://localhost:8082/deboizando) 
5. To exit, just enter `docker stop <container-id>`

### GitHub - DEPLOYMENT & DOCKER
1. To deploy the application, access its root project folder and execute: `./gradlew bootJar`
2. In order to build github's image on docker, it's necessary to access the Tema-07/microservice-github or GitHub's root directory (where Dockerfile is located) and then run: 
`docker build -t github .`
3. Since the image is built, run: `sudo docker run -p 8081:8081 -d github`
4. Now, all you need to do is start the server and access [localhost:8081/{user}/](http://localhost:8081/deborawendland) 
5. To exit, just enter `docker stop <container-id>`

### Integration - DEPLOYMENT & DOCKER
1. To deploy the application, access its root project folder and execute: `./gradlew bootJar`
2. In order to build integration's image on docker, it's necessary to access the Tema-07/microservice-integration or Integration's root directory (where Dockerfile is located) and then run: 
`docker build -t integration .`
3. Since the image is built, run: `sudo docker run -p 8080:8080 --network=host -d integration`
4. Now, all you need to do is start the server and access [localhost:8080/twitter/{user}/](http://localhost:8080/twitter/deboizando) 
5. To exit, just enter `docker stop <container-id>`

### GITHUB - TWITTER MICROSERVICES 
* The searches supported by the GitHub-Twitter Integration are:
  * Total number of public repositories of a provided GitHub's user account
  * Total number of tweets of a provided Twitter's user account
* In order to perform the Twitter search, follow the pattern below:
  * `http://localhost:8080/twitter/{userAccount}` 
* In order to perform the GitHub search, follow the pattern below:
  * `http://localhost:8080/github/{userAccount}` 
