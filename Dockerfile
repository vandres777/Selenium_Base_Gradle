# Usar una imagen base de Java
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo de construcción de Gradle, el script de Gradle Wrapper y el código fuente
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle
COPY src ./src

# Dar permisos de ejecución al script de Gradle Wrapper
RUN chmod +x gradlew

# Construir la aplicación
RUN ./gradlew build

# Comando para ejecutar la aplicación
CMD ["./gradlew", "test"]