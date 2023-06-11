package com.ben.java.gof.structural_model.bridge.message;

/**
 * @author: ben.xia
 * @desc: 加急信息
 * @date: 2023/6/11
 */
public class UrgencyMessage extends AbastractMessage {

    public UrgencyMessage(IMessage iMessage) {
        super(iMessage);
    }

    void sendMessage(String message, String toUser) {
        message = "[加急]" + message;
        super.sendMessage(message,toUser);
    }
}
