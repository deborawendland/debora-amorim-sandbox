FROM openjdk:8
EXPOSE 8082
ARG JAR_FILE=build/libs/twitter.jar
ADD ${JAR_FILE} twitter.jar
ENTRYPOINT ["java","-jar","/twitter.jar"]


