FROM frolvlad/alpine-oraclejdk8:slim

MAINTAINER Christian Plonka "cplonka81@gmail.com"

VOLUME /tmp

# bad practise: use own layer for dependencies
COPY ./com.cxplonka.feature.application/build/libs/com.cxplonka.feature.application-1.0-snapshot.jar app.jar
RUN sh -c 'touch /app.jar'

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]