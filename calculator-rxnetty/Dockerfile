FROM java:8
ADD ./build/libs/calculator.jar calculator.jar
ENTRYPOINT ["java", "-jar", "calculator.jar"]
EXPOSE 8080