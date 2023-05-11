# Use an OpenJDK base image
FROM openjdk:17-jdk-slim
# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/*.jar app.jar

# Expose the port on which your appdocker run -d --name your-container-name --link mysql_container:mysql -p 8080:8080 your-image-namelication runs
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "app.jar"]
