import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
* @author xbhfree
* date:2022-05-25
*/
public class Consumer {
    public static void main(String[] args) throws JMSException {
        //创建工厂
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, "tcp://127.0.0.1:61616");
        //创建链接
        Connection connection = factory.createConnection();
        //开始链接
        connection.start();
        //创建会话，关闭事务，签收模式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建队列
        Queue queue = session.createQueue("activemq-queue");
        //消息消费者
        MessageConsumer consumer = session.createConsumer(queue);
        while (true){
            TextMessage message = (TextMessage)consumer.receive();
            if (message != null){
                System.out.println("收到的消息=" + message.getText());
            }else{
                break;
            }
        }
        connection.close();

    }
}
