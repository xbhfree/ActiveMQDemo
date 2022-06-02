package com.activemq.controller;

import com.activemq.component.SendServer;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @author xbhfree
* date:2022-05-27
*/
@RestController
public class UserController {
    @Autowired
    private SendServer sendServer;

    @RequestMapping("/register")
    public String register(String name){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", "email");
        jsonObject.put("to", "xbhfree@163.com");
        jsonObject.put("content", "hello activemq");
        sendServer.send(jsonObject.toJSONString());
        return "register success";
    }
}
