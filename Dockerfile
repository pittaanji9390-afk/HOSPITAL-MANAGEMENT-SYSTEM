# ==============================================================================
# Production Multi-Stage Dockerfile for Enterprise Hospital Management System
# ==============================================================================

# Stage 1: Build React 19 Frontend
FROM node:20-alpine AS frontend-builder
WORKDIR /app/frontend
COPY frontend/package*.json ./
RUN npm ci || npm install
COPY frontend/ ./
RUN npm run build

# Stage 2: Build Spring Boot 3.3 Backend
FROM eclipse-temurin:21-jdk-alpine AS backend-builder
WORKDIR /app/backend
COPY backend/pom.xml ./
COPY backend/src ./src
RUN apk add --no-cache maven && mvn clean package -DskipTests

# Stage 3: Production Runtime Container
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
VOLUME /tmp

# Copy compiled backend JAR and frontend build artifacts
COPY --from=backend-builder /app/backend/target/*.jar app.jar
COPY --from=frontend-builder /app/frontend/dist ./public

EXPOSE 8080 5173

ENV SPRING_PROFILES_ACTIVE=prod
ENV JAVA_OPTS="-XX:+UseG1GC -XX:MaxRAMPercentage=75.0"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
