package com.activemq.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
* @author xbhfree
* date:2022-05-25
*/
public class ProducerDemo {
    public static void main(String[] args) throws JMSException {
        //得到工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,"tcp://127.0.0.1:61616");
        //创建JMS链接
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //创建session，是否开启事务，签收模式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建队列
        Queue queue = session.createQueue("activemq-queue");
        //消息生产者
        MessageProducer producer = session.createProducer(queue);
        //设置交付模式，非持久化
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        //发送消息
        String content = "hello activemq";
        TextMessage message = session.createTextMessage(content);
        producer.send(message);
        System.out.println("send success");
        //关闭链接
        connection.close();


    }
}
