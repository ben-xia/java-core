package com.ben.java.gof.behavioral_model.chain.primarychain;

/**
 * 用户登录
 */
public class LoginHandle extends Handler {
    @Override
    protected void doHandle(User user) {
        if (!("管理员".equals(user.getName()) && "123456".equals(user.getPassword()))) {
            System.out.println("用户名或者密码错误,请重试");
            return;
        }
        System.out.println("用户登录成功");
        this.nextHandle.doHandle(user);
    }
}
