FROM maven:3.9.6-eclipse-temurin-21

RUN apt-get update && \
    apt-get install -y ffmpeg && \
    apt-get clean

WORKDIR /app
COPY . .
RUN mvn dependency:resolve
CMD ["mvn", "test"]
