FROM eclipse-temurin:17

WORKDIR /app

COPY . /app

RUN ./mvnw clean package

RUN ls -l target/

COPY target/shopping-java.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
