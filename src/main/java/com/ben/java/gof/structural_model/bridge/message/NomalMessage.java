package com.ben.java.gof.structural_model.bridge.message;

/**
 * @author: ben.xia
 * @desc: 普通消息
 * @date: 2023/6/11
 */
public class NomalMessage extends AbastractMessage{
    public NomalMessage(IMessage iMessage) {
        super(iMessage);
    }

    void sendMessage(String message, String toUser) {
        super.sendMessage(message,toUser);
    }
}
