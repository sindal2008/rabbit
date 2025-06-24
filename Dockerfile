FROM maven:3.9.6-eclipse-temurin-21

# Установка зависимостей
RUN apt-get update && apt-get install -y \
    wget \
    gnupg \
    ffmpeg \
    xvfb \
    fluxbox \
    curl \
    unzip \
    fonts-liberation \
    libappindicator3-1 \
    libasound2 \
    libatk-bridge2.0-0 \
    libatk1.0-0 \
    libcups2 \
    libdbus-1-3 \
    libgdk-pixbuf2.0-0 \
    libnspr4 \
    libnss3 \
    libxcomposite1 \
    libxdamage1 \
    libxrandr2 \
    libxss1 \
    libxtst6 \
    x11-utils \
    --no-install-recommends && \
    rm -rf /var/lib/apt/lists/*

# Установка Google Chrome
RUN wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - && \
    echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" \
    > /etc/apt/sources.list.d/google-chrome.list && \
    apt-get update && \
    apt-get install -y google-chrome-stable && \
    rm -rf /var/lib/apt/lists/*

# Переменная окружения для Xvfb
ENV DISPLAY=:99

# Рабочая директория
WORKDIR /app
COPY . .

# Запуск Xvfb и тестов
CMD xvfb-run --server-args="-screen 0 1920x1080x24" mvn test \
  -Dvideo.enabled=false \
  -Dsurefire.suiteXmlFiles=./src/test/resources/testng.xml
