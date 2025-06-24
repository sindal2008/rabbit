FROM maven:3.9.6-eclipse-temurin-21 as build

# Установка зависимостей
RUN apt-get update && apt-get install -y \
    ffmpeg \
    xvfb \
    x11-utils \
    fluxbox \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app
COPY . .

# Запускаем Xvfb и mvn тесты
CMD xvfb-run --server-args="-screen 0 1920x1080x24" mvn test \
  -Dvideo.folder=target/videos \
  -Dvideo.enabled=true \
  -Dvideo.mode=ALL \
  -Drecorder.type=FFMPEG \
  -Dvideo.save.mode=ALL \
  -Dsurefire.suiteXmlFiles=./src/test/resources/testng.xml
