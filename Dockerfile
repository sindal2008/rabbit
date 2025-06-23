# Используем официальный образ Maven с Java 17
FROM maven:3.9.6-eclipse-temurin-17

# Обновляем пакеты и устанавливаем FFMPEG
RUN apt-get update && \
    apt-get install -y ffmpeg && \
    apt-get clean

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем все файлы проекта в контейнер
COPY . .

# (Необязательно) Скачиваем зависимости заранее, чтобы ускорить сборку
RUN mvn dependency:resolve

# Команда по умолчанию (можно переопределить в GitHub Actions)
CMD ["mvn", "test"]
