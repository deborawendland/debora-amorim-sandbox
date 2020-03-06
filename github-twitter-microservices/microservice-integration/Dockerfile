FROM openjdk:8
EXPOSE 8080
ARG JAR_FILE=build/libs/integration.jar
ADD ${JAR_FILE} integration.jar
ENTRYPOINT ["java","-jar","/integration.jar"]