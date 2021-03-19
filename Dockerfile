FROM openjdk:13-jdk-alpine
VOLUME /tmp
COPY target/kg.csi-*.jar /app/app.jar
CMD ["java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "/app/app.jar"]