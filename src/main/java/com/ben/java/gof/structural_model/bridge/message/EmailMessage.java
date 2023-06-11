package com.ben.java.gof.structural_model.bridge.message;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/6/11
 */
public class EmailMessage implements IMessage{
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用邮件消息发送"+message+"给"+toUser);
    }
}
