package com.activemq.component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
/**
* @author xbhfree
* date:2022-05-27
*/
@Component
public class Consumer {
    @JmsListener(destination = "${queue}")
    public void receive(String msg){
        JSONObject jsonObject = JSON.parseObject(msg);
        if("email".equals(jsonObject.get("type")));{
            System.out.println("listener get msg:send email to" + jsonObject.get("to") + ",content is " + jsonObject.get("content"));
        }
    }
}
