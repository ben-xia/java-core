package com.ben.java.gof.behavioral_model.chain.primarychain;

/**
 * 权限校验
 */
public class AuthHandle extends Handler{
    @Override
    protected void doHandle(User user) {
        if (!"管理员".equals(user.getRoleName())){
            System.out.println("您不是管理员, 您没有权限操作");
            return;
        }
        System.out.println("管理员运行操作");
    }
}
