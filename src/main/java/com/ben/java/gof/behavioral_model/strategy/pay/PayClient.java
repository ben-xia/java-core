package com.ben.java.gof.behavioral_model.strategy.pay;

import java.math.BigDecimal;

/**
 * @author: ben.xia
 * @desc: 用户侧
 * @date: 2023/5/2
 */
public class PayClient {
    public static void main(String[] args) {
        //    调用方入参order
        PayOrder payOrder = new PayOrder("admin", "90000", BigDecimal.ONE);

        //用户选择的支付方式支付
        System.out.println(payOrder.doPay("alipay"));;
    }

}
