FROM openjdk:8
COPY target/*.jar  eureka.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/eureka.jar"]
