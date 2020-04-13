FROM openjdk:8-jdk-alpine
COPY target/*.jar app.jar
EXPOSE 8088
ENTRYPOINT ["java","-jar","/app.jar"]

