# Use Java base image
FROM eclipse-temurin:17-jre-jammy

# Set working directory
WORKDIR /app

# Copy build output from Gradle
COPY build/libs/cicd-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
