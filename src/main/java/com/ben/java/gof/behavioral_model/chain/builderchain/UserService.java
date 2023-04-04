package com.ben.java.gof.behavioral_model.chain.builderchain;

/**
 * 用户登录服务
 */
public class UserService {

    public void doLogin(User user){
        Handler handler = new Handler.Builder()
                .addHandle(new ValidateHandler())
                .addHandle(new LoginHandle())
                .addHandle(new AuthHandle())
                .builder();
        handler.doHandle(user);
    }
}
