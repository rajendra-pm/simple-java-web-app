# Use OpenJDK base image
FROM openjdk:11

# Copy Java file
COPY Main.java /app/Main.java

# Compile Java file
RUN javac /app/Main.java

# Run the program
CMD ["java", "-cp", "/app", "Main"]
