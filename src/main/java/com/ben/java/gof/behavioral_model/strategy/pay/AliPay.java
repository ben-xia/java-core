package com.ben.java.gof.behavioral_model.strategy.pay;

import java.math.BigDecimal;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/2
 */
public class AliPay extends Payment{
    @Override
    protected BigDecimal queryBalance(String uid) {
        return BigDecimal.ZERO;
    }

    @Override
    protected String getName() {
        return "支付宝";
    }
}
