package com.ben.java.gof.structural_model.adapter.passport.v2.adapters;

import com.ben.java.gof.ResultMsg;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/2
 */
public class LoginForTokenAdapter implements ILoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return false;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
