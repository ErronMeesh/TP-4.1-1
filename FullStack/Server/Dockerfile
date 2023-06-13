FROM openjdk:8
VOLUME /tmp
EXPOSE 8080
COPY target/Server-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]