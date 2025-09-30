# Use OpenJDK base image
FROM openjdk:11

# Copy Java file
COPY Main.java /app/Main.java

# Compile Java file
RUN javac /app/Main.java

# Expose port 8080
EXPOSE 8080

# Run the program
CMD ["java", "-cp", "/app", "Main"]
