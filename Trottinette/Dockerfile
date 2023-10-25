FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/*.jar trottinette.jar
ENTRYPOINT ["java","-jar","/trottinette.jar"]