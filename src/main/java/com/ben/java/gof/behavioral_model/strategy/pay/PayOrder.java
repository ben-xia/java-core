package com.ben.java.gof.behavioral_model.strategy.pay;

import com.ben.java.gof.ResultMsg;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/2
 */

public class PayOrder {
    private String uid;
    private String orderId;
    private BigDecimal amount;

    public PayOrder(String uid, String orderId, BigDecimal amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ResultMsg doPay(String payKey) {
        Payment payment = PaymentFactory.getPayment(payKey);
        System.out.println("欢迎使用" + payment.getName());
        System.out.println("本次交易金额" + amount);
        return payment.pay(uid, amount);
    }
}
