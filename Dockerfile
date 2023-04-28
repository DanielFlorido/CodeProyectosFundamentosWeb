FROM openjdk:11-jre-slim

RUN mkdir /app
COPY zip/target/demo-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

ENV DB_URL=jdbc:mysql://containers-us-west-101.railway.app:6611/railway
ENV DB_USERNAME=root
ENV DB_PASSWORD=GpOw23JDDoZlsLF98AQ2

CMD ["java", "-jar", "/app/app.jar"]