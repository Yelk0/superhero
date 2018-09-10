FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8443
ARG JAR_FILE
COPY ${JAR_FILE} superheroapp.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/superheroapp.jar"]