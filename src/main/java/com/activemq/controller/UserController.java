package com.activemq.controller;

import com.activemq.service.ProducerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

/**
* @author xbhfree
* date:2022-05-27
*/
@RestController
public class UserController {
    @Autowired
    private ProducerService service;

    @GetMapping("/register")
    public String register(String name){
        Destination destination = new ActiveMQQueue("user.queue");
        service.sendMessage(destination, name);
        return "register success";
    }
}
