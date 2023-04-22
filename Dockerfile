FROM openjdk:11-jre-slim

RUN mkdir /app

COPY zip/target/demo-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

ENV DB_URL=jdbc:mysql://root:aVMqaTkYSsDVqHfNq9yN@containers-us-west-103.railway.app:5729/railway
ENV DB_USERNAME=root
ENV DB_PASSWORD=aVMqaTkYSsDVqHfNq9yN

CMD ["java", "-jar", "/app/app.jar"]
