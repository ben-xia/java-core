package com.ben.java.gof.structural_model.adapter.passport.v2.adapters;

import com.ben.java.gof.structural_model.adapter.passport.PasswortService;
import com.ben.java.gof.structural_model.adapter.passport.ResultMsg;
import org.apache.commons.lang.StringUtils;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/2
 */
public class LoginForWechatAdapter extends AbstraceAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForWechatAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return super.login(id,null);
    }


}
