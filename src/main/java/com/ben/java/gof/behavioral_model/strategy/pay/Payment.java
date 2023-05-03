package com.ben.java.gof.behavioral_model.strategy.pay;

import com.ben.java.gof.ResultMsg;

import java.math.BigDecimal;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/2
 */
public abstract class Payment {
    /**
     * 模板方法
     * @param uid
     * @param amout
     * @return
     */
    public ResultMsg pay(String uid, BigDecimal amout) {
        BigDecimal balance = queryBalance(uid);
        if (balance.compareTo(amout) < 0) {
            return new ResultMsg("500", "账户余额不足", "账户余额不足");
        }
        // 真正的执行减金额操作[可以做成钩子方法]
        return new ResultMsg("200", "支付成功", "支付金额:"+amout);
    }

    /**
     * 钩子方法: 去支付宝,微信,银行查用户余额
     * @param uid
     * @return
     */
    protected abstract BigDecimal queryBalance(String uid);

    protected abstract String getName();
}
