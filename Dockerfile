# Construcción
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar archivos de configuración de Maven 
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .

# Descargar dependencias 
RUN mvn dependency:go-offline -B

# Copiar el código fuente y compilar
COPY src ./src
RUN mvn clean package -DskipTests

# Ejecución
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiar solo el JAR generado desde la etapa de construcción
COPY --from=build /app/target/techstore-api-1.0.0.jar app.jar

# Ejecutar como usuario no-root (seguridad)
USER nobody

# Documentar el puerto que expone la aplicación
EXPOSE 8080

# Comando de inicio
ENTRYPOINT ["java", "-jar", "app.jar"]