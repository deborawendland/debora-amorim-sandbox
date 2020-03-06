FROM openjdk:8
EXPOSE 8081
ARG JAR_FILE=build/libs/github.jar
ADD ${JAR_FILE} github.jar
ENTRYPOINT ["java","-jar","/github.jar"]