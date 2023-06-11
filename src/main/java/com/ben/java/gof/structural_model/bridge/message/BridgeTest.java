package com.ben.java.gof.structural_model.bridge.message;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/6/11
 */
public class BridgeTest {

    public static void main(String[] args) {
        IMessage iMessage = new SmsMessage();
        AbastractMessage UrgencyMessage = new UrgencyMessage(iMessage);
        iMessage.send("加班","张三");
        UrgencyMessage.sendMessage("加班","张三");
    }
}
