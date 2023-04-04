package com.ben.java.gof.behavioral_model.chain.primarychain;

/**
 * 用户登录服务
 */
public class UserService {

    public void doLogin(User user){
        ValidateHandler validateHandler = new ValidateHandler();
        LoginHandle loginHandle = new LoginHandle();
        AuthHandle authHandle = new AuthHandle();

        validateHandler.setNextHandle(loginHandle);
        loginHandle.setNextHandle(authHandle);
        validateHandler.doHandle(user);
    }
}
