FROM openjdk:11-jre-slim
VOLUME /tmp
COPY your-app.jar your-app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/your-app.jar"]
