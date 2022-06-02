package com.activemq.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
* @author xbhfree
* date:2022-05-27
*/
@Component
public class SendServer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;

    public void send(String msg){
        jmsMessagingTemplate.convertAndSend(queue, msg);
    }

}
