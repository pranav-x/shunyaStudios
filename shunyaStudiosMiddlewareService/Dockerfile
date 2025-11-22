# ---- Build stage ----
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# Copy Gradle wrapper + config
COPY gradlew gradlew.bat build.gradle settings.gradle ./
COPY gradle ./gradle

# Make wrapper executable
RUN chmod +x gradlew

# Copy source
COPY src ./src

# Build fat jar (Spring Boot)
RUN ./gradlew clean bootJar -x test --no-daemon

# ---- Run stage ----
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
