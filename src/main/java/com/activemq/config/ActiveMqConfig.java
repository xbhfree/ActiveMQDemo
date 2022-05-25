package com.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;
/**
 * @author xbhfree
 * */
@Configuration
public class ActiveMqConfig {

    @Value("${queue}")
    private String queue;

    @Bean
    public Queue queue(){
        return new ActiveMQQueue(queue);
    }

    @Bean
    public Queue logQueue(){
        return new ActiveMQQueue("fore.queue");
    }

    @Bean
    public Topic createTopic(){
        return new ActiveMQTopic("java2.bos.sms");
    }
}
