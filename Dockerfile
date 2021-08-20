# #
# # Build stage
# #
# FROM maven:3.6.0-jdk-11-slim AS build
# COPY src /home/app/src
# COPY pom.xml /home/app
# RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/qrcoderedemption-0.0.1-SNAPSHOT.jar qrcoderedemption.jar
EXPOSE 8000
ENTRYPOINT exec java $JAVA_OPTS -jar qrcoderedemption.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar qrcoderedemption.jar
