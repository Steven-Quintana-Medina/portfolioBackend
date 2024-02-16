FROM maven:3.9.6-eclipse-temurin AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

EXPOSE ${SERVER_PORT}

COPY --from=build /target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]