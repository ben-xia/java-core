package com.ben.java.gof.structural_model.adapter.passport.v1;

import com.ben.java.gof.structural_model.adapter.passport.PasswortService;
import com.ben.java.gof.ResultMsg;
import org.apache.commons.lang.StringUtils;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/1
 */
public class PasswortForThirdAdapter extends PasswortService implements IPasswortForThird {

    @Override
    public ResultMsg loginForWechat(String openId) {
        return this.registAndLogin(openId, null);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return this.registAndLogin(token, null);
    }

    @Override
    public ResultMsg loginForWeTelphone(String phone, String code) {
        //调电信服务商API
        return this.registAndLogin(phone, null);
    }

    @Override
    public ResultMsg loginForEmail(String email, String code) {
        //调邮件服务商API
        return this.registAndLogin(email, null);
    }

    private ResultMsg registAndLogin(String userName, String password) {
        if (StringUtils.isBlank(password)) {
            password = "admin";
        }
        super.regist(userName, password);
        return super.login(userName, password);
    }
}
