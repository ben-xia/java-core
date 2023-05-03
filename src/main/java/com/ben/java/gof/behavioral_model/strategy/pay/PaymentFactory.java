package com.ben.java.gof.behavioral_model.strategy.pay;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/2
 */
public class PaymentFactory {
    private static final Map<String, Payment> pool = new HashMap<>();

    static {
        pool.put(PaymentKey.ALI_PAY, new AliPay());
        pool.put(PaymentKey.WECHAT_PAY, new WechatPay());
        pool.put(PaymentKey.UNION_PAY, new UnionPay());
    }

    public static final Payment DEFAULT_PAY = pool.get(PaymentKey.ALI_PAY);

    private PaymentFactory() {
    }

    public static Payment getPayment(String payKey) {
        Payment payment = pool.get(payKey);
        return null == payment ? DEFAULT_PAY : payment;
    }

    private interface PaymentKey {
        String ALI_PAY = "alipay";
        String WECHAT_PAY = "wechatpay";
        String UNION_PAY = "unionpay";
    }
}
