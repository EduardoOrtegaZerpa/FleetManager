# Usar una imagen base de Maven con JDK 17
FROM maven:3.8.4-openjdk-17 AS build

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo pom.xml y descargar las dependencias
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el resto del proyecto al contenedor
COPY src ./src

# Compilar la aplicación con Maven
RUN mvn clean package -DskipTests

# Usar una imagen base de OpenJDK 17 para ejecutar la aplicación
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo para la aplicación
WORKDIR /app

# Copiar el archivo JAR generado desde la fase anterior
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto 8080 para que la aplicación esté disponible
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
