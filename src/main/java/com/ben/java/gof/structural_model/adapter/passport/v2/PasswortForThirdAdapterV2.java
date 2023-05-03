package com.ben.java.gof.structural_model.adapter.passport.v2;

import com.ben.java.gof.ResultMsg;
import com.ben.java.gof.structural_model.adapter.passport.v2.adapters.*;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/1
 */
public class PasswortForThirdAdapterV2  implements IPasswortForThirdV2 {

    @Override
    public ResultMsg loginForWechat(String openId) {
        return this.processLogin(openId, LoginForWechatAdapter.class);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return this.processLogin(token, LoginForTokenAdapter.class);
    }

    @Override
    public ResultMsg loginForWeTelphone(String phone, String code) {
        //调电信服务商API
        return this.processLogin(phone, LoginForPhoneAdapter.class);
    }

    @Override
    public ResultMsg loginForEmail(String email, String code) {
        //调邮件服务商API
        return this.processLogin(email, LoginForEmailAdapter.class);
    }

    private ResultMsg processLogin(String id,Class<? extends ILoginAdapter> clazz){
        try {
            ILoginAdapter adapter = clazz.newInstance();
            if (adapter.support(adapter)) {
                adapter.login(id, adapter);
            }
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
