# Use a slim JDK base image for smaller size
FROM openjdk:11-jre-slim AS builder

# Set working directory for build stage
WORKDIR /app

# Copy project code for building the JAR (assuming Maven)
COPY pom.xml ./
COPY src ./src

# Build the JAR using Maven (adjust command if you use a different tool)
RUN mvn package

# Create a separate stage for the final image (avoids unnecessary build steps)
FROM openjdk:11-jre-slim

# Set working directory for final image
WORKDIR /app

# Copy only the JAR file, not the entire project code
COPY ./target/demo-0.0.1-SNAPSHOT.jar app.jar

# Copy the JSON credentials file (consider environment variables instead)
COPY ./src/main/resources/json_directory/smart-window-413315-a416affd1d62.json /app/credentials.json


# Set the entry point with security option (consider secrets management)
ENTRYPOINT ["java", "-jar", "app.jar"]

# Optional: Expose a port if your application listens on one
EXPOSE 8785
