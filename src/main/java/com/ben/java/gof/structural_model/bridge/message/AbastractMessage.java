package com.ben.java.gof.structural_model.bridge.message;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/6/11
 */
public abstract class AbastractMessage {
    private IMessage iMessage;

    public AbastractMessage(IMessage iMessage) {
        this.iMessage = iMessage;
    }

    void sendMessage(String message, String toUser) {
        iMessage.send(message,toUser);
    }
}
