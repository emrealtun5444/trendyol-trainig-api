FROM openjdk:17-oracle AS build-project
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/app.jar"]