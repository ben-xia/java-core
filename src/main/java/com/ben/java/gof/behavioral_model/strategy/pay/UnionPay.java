package com.ben.java.gof.behavioral_model.strategy.pay;

import java.math.BigDecimal;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/2
 */
public class UnionPay extends Payment{
    @Override
    protected BigDecimal queryBalance(String uid) {
        return BigDecimal.TEN;
    }

    @Override
    protected String getName() {
        return "银联支付";
    }
}
