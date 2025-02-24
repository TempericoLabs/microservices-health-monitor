FROM eclipse-temurin:11-jre-alpine
WORKDIR /app
COPY target/weather-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]