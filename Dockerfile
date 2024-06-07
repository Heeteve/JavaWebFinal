FROM openjdk:17-jdk-alpine
COPY ./target/JavaWebFinal-0.0.1-SNAPSHOT.jar /usr/app/
COPY ./target/classes/static /usr/app/classes/static
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/JavaWebFinal-0.0.1-SNAPSHOT.jar"]