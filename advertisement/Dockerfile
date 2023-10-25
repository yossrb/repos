FROM openjdk:8-jdk-alpine
EXPOSE 8087
ADD target/*.jar advertisement.jar
ENTRYPOINT ["java","-jar","/advertisement.jar"]