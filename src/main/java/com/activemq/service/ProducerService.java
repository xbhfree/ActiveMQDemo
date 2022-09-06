package com.activemq.service;

import javax.jms.Destination;

public interface ProducerService {

    /**
     *
     * @param destination
     * @param message
     */
    void sendMessage(Destination destination, final String message);
}
