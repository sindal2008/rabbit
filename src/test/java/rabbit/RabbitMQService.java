package rabbit;

import com.rabbitmq.client.*;

public class RabbitMQService {

    private static final String QUEUE_NAME = "hello";

    // Метод для отправки сообщения в очередь
    public void sendMessage(String message) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("Sent: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Метод для получения сообщения из очереди
    public String receiveMessage() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            GetResponse response = channel.basicGet(QUEUE_NAME, true);
            if (response != null) {
                String message = new String(response.getBody(), "UTF-8");
                System.out.println("Received: " + message);
                return message;
            } else {
                System.out.println("No message in the queue");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
