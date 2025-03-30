FROM eclipse-temurin:17-alpine

WORKDIR /app

COPY . /app

RUN chmod +x ./mvnw && ./mvnw clean package

COPY target/shopping-java.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
