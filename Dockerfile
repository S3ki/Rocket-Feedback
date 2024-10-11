# Use an official OpenJDK image as a parent image
FROM openjdk:20-jdk-slim

# Set metadata information
LABEL authors="seki"

# Set the working directory in the container
WORKDIR /app

# Install Maven, JavaFX, Xvfb, VNC libraries, and Mesa for software OpenGL
RUN apt-get update && apt-get install -y \
    maven \
    libx11-6 \
    libgl1-mesa-glx \
    libxtst6 \
    libxrender1 \
    libxext6 \
    xvfb \
    x11vnc \
    mesa-utils \
    && rm -rf /var/lib/apt/lists/*

# Copy the pom.xml file to the container
COPY pom.xml /app/

# Copy the entire project to the container
COPY . /app/

# Clean and package the application
RUN mvn clean package

# Set the DISPLAY environment variable for Xvfb
ENV DISPLAY=:99

# Start Xvfb, VNC, and the Java application with software rendering and verbose logging
CMD ["sh", "-c", "Xvfb :99 -screen 0 1024x768x16 & x11vnc -display :99 -nopw -forever & java -Dprism.order=sw -Dprism.verbose=true -jar target/RocketFeed.jar"]
