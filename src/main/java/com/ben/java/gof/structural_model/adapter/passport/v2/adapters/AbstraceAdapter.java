package com.ben.java.gof.structural_model.adapter.passport.v2.adapters;

import com.ben.java.gof.structural_model.adapter.passport.PasswortService;
import com.ben.java.gof.ResultMsg;
import org.apache.commons.lang.StringUtils;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/2
 */
public abstract class AbstraceAdapter extends PasswortService implements ILoginAdapter {
    private ResultMsg registAndLogin(String userName, String password) {
        if (StringUtils.isBlank(password)) {
            password = "admin";
        }
        super.regist(userName, password);
        return super.login(userName, password);
    }
}
