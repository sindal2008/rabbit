# Используем Maven с Java 21
FROM maven:3.9.6-eclipse-temurin-21

# Устанавливаем FFMPEG
RUN apt-get update && \
    apt-get install -y ffmpeg && \
    apt-get clean

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем проект в контейнер
COPY . .

# Предзагрузка зависимостей (опционально)
RUN mvn dependency:resolve

# Команда по умолчанию (можно переопределить в GitHub Actions)
CMD ["mvn", "test"]
