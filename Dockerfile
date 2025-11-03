# Etapa 1: build
FROM eclipse-temurin:17-alpine AS builder

WORKDIR /app
COPY . .
RUN chmod +x ./mvnw && ./mvnw clean package -DskipTests

# Etapa 2: runtime optimizada para AWS Free Tier
FROM eclipse-temurin:17-jre-alpine

# Crear usuario no-root por seguridad
RUN addgroup -g 1001 -S appgroup && \
    adduser -u 1001 -S appuser -G appgroup

# Instalar herramientas necesarias
RUN apk add --no-cache curl dumb-init

# Crear directorios necesarios
RUN mkdir -p /app /var/log/shopping-java && \
    chown -R appuser:appgroup /app /var/log/shopping-java

# Copiar JAR desde build stage
COPY --from=builder /app/target/shopping-java.jar /app/app.jar
RUN chown appuser:appgroup /app/app.jar

# Cambiar a usuario no-root
USER appuser

# Variables de entorno optimizadas para Free Tier (1GB RAM)
ENV JAVA_OPTS="-Xms128m -Xmx512m -XX:+UseG1GC -XX:MaxGCPauseMillis=200 -XX:+UnlockExperimentalVMOptions -XX:+UseContainerSupport -Djava.security.egd=file:/dev/./urandom"
ENV PROFILE_ACTIVE=prod

# Health check
HEALTHCHECK --interval=30s --timeout=10s --start-period=60s --retries=3 \
  CMD curl -f http://localhost:8080/api/actuator/health || exit 1

# Usar dumb-init para manejo correcto de señales
ENTRYPOINT ["dumb-init", "--"]

# Comando con configuraciones optimizadas
CMD ["sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=$PROFILE_ACTIVE -jar /app/app.jar"]

# Labels para metadata
LABEL maintainer="brunjo12@hotmail.com"
LABEL version="1.0"
LABEL description="Shopping Java Application - AWS Free Tier Optimized"

# Exponer puerto
EXPOSE 8080
