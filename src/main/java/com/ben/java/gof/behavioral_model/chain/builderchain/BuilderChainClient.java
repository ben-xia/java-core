package com.ben.java.gof.behavioral_model.chain.builderchain;


public class BuilderChainClient {

    public static void main(String[] args) {
        UserService userService = new UserService();
        User user = new User();
        user.setRoleName("管理员");
        user.setName("管理员");
        user.setPassword("123456");
        userService.doLogin(user);
    }
}
