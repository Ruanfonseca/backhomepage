# Use a imagem base do OpenJDK
FROM openjdk:17-alpine

ADD target/sendmail-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
