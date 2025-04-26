//package rabbit;
//
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
////ci test
//public class RabbitMQServiceTest {
//
//    private RabbitMQService rabbitMQService;
//
//    @BeforeClass
//    public void setUp() {
//        rabbitMQService = new RabbitMQService();
//    }
//
//    @Test
//    public void testSendMessage() {
//        // Отправляем сообщение
//        String message = "Hello RabbitMQ!";
//        rabbitMQService.sendMessage(message);
//
//        // Пытаемся получить сообщение
//        String receivedMessage = rabbitMQService.receiveMessage();
//
//        // Проверяем, что сообщение получено корректно
//        Assert.assertEquals(receivedMessage, message, "Сообщения не совпадают!");
//    }
//
//    @Test
//    public void testReceiveNoMessage() {
//        // Пытаемся получить сообщение, когда в очереди ничего нет
//        String receivedMessage = rabbitMQService.receiveMessage();
//
//        // Проверяем, что сообщение равно null
//        Assert.assertNull(receivedMessage, "Сообщение не должно быть найдено!");
//    }
//}
//
