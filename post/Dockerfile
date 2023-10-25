FROM openjdk:8-jdk-alpine
EXPOSE 8087
ADD target/*.jar post.jar
ENTRYPOINT ["java","-jar","/post.jar"]