FROM openjdk:11-jre-slim

RUN mkdir /app

COPY zip/target/demo-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

ENV DB_URL=jdbc:mysql://localhost:3306/proyecto
ENV DB_USERNAME=root
ENV DB_PASSWORD=password

CMD ["java", "-jar", "/app/app.jar"]
