FROM maven:3.8.7-openjdk-18-slim

LABEL maintainer="Ilmira"
LABEL description="JiraRush app"
LABEL version="1.0"
LABEL profiles="prod for run with postgresql in compose"
LABEL build="docker build -t jira-prod-img ."
LABEL run="docker-compose up -d"

WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY resources ./resources
COPY lombok.config ./lombok.config
COPY config/_application-prod.yaml ./src/main/resources/application.yaml
RUN mvn clean package -DskipTests
RUN mv ./target/*.jar ./app.jar
RUN rm -rf ./target
RUN rm -rf ./src
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/app.jar"]