package com.ben.java.gof.behavioral_model.chain.builderchain;

import com.ben.java.gof.behavioral_model.chain.builderchain.User;
import org.apache.commons.lang.StringUtils;

import java.util.Objects;

/**
 * 参数校验
 */
public class ValidateHandler  extends Handler {
    @Override
    protected void doHandle(User user) {
        if (Objects.isNull(user)||StringUtils.isBlank(user.getName()) || StringUtils.isBlank(user.getPassword())){
            System.out.println("用户登录信息不能为空");
            return;
        }
        System.out.println("用户登录信息基础校验通过");
        this.nextHandle.doHandle(user);
    }
}
