FROM openjdk:17-oracle
COPY ./target/web-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 7677

ENTRYPOINT ["java", "-jar", "web-0.0.1-SNAPSHOT.jar"]