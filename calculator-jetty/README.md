# Calculator using Spring and Jetty
HomeWork 04 - Cloud Native

### JETTY
1. To use the webapp, it's necessary to download [Jetty](https://www.eclipse.org/jetty/download.html) (version = 9.4)
2. To start the server, access the main folder and, via terminal, execute the command `java -jar start.jar`
3. In order to verify, access [localhost, port: 8080](http://localhost:8080/) by the browser
4. To stop the server, press `ctrl+c`

### CALCULATOR - DEPLOYMENT
5. To deploy the application, access its root project folder and execute: `./gradlew deploy`
6. Access `build/libs` and copy the `.war` file
7. Paste the file into the Jetty's `.webapps/` directory
8. Now, all you need to do is start the server and access [localhost:8080/calculator/](http://localhost:8080/calculator/) 

### CALCULATOR WEBAPP 
* The math operations supported by the calculator are:
  * sum
  * sub
  * mul
  * div
  * exp
* To execute an operation, follow the pattern below:
  * Example a: 9/3
  * `localhost:8080/calculator/?op=div&firstTerm=9&secondTerm=3` 
  * Example b: 6-7
  * `localhost:8080/calculator/?op=sub&firstTerm=6&secondTerm=7` 
* To access calculator logs, just enter:
  * `localhost:8080/calculator/?logs` 
