FROM openjdk:23-jdk-slim

ADD build/libs/product-producer-0.0.1-SNAPSHOT.jar product-producer-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "product-producer-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=docker"]