# Etapa 1: build
FROM eclipse-temurin:17-alpine AS builder

WORKDIR /app
COPY . .
RUN chmod +x ./mvnw && ./mvnw clean package -DskipTests

# Etapa 2: runtime
FROM eclipse-temurin:17-alpine

COPY --from=builder /app/target/shopping-java.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
