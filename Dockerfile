FROM maven:3.9-eclipse-temurin-21-alpine AS build
COPY /src /src
COPY checkstyle-suppressions.xml /
COPY pom.xml /
RUN mvn -f /pom.xml clean package

FROM openjdk:21-jdk-slim
COPY --from=build /target/*.jar application.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "application.jar"]