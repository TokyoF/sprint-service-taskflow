
# Usar una imagen base de JDK para ejecutar Spring Boot
FROM openjdk:17-jdk-alpine

# Copiar el archivo JAR generado
COPY target/sprint-management-0.0.1-SNAPSHOT.jar sprint-service.jar

# Exponer el puerto configurado
EXPOSE 8095

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/sprint-service.jar"]
