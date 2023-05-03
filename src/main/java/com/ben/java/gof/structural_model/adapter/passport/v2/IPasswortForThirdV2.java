package com.ben.java.gof.structural_model.adapter.passport.v2;

import com.ben.java.gof.ResultMsg;

/**
 * @author: ben.xia
 * @desc:  第三方登录服务
 * @date: 2023/5/1
 */
public interface IPasswortForThirdV2 {
    ResultMsg loginForWechat(String openId);

    ResultMsg loginForToken(String token);

    ResultMsg loginForWeTelphone(String phone, String code);

    ResultMsg loginForEmail(String email, String code);
}
