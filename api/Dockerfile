FROM openjdk:17-oracle
COPY ./target/api-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 7676

ENTRYPOINT ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]