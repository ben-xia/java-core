package com.ben.java.gof.structural_model.bridge.message;

/**
 * @author
 * @date 2023/06/11
 * @Description TODO
 **/
public interface IMessage {
    //    消息的内容和接收人
     public void send(String message, String toUser);
}
