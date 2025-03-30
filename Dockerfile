FROM eclipse-temurin:17

COPY target/shopping-java.jar /app.jar

ENTRYPOINT java $JAVA_OPTS -jar /app.jar
