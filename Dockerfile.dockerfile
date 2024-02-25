FROM openjdk:11-jre-slim
VOLUME /tmp
WORKDIR /app
COPY ./target/demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
LABEL "com.example.image-name"="asia-south2-docker.pkg.dev/smart-window-413315/springbootjava"

