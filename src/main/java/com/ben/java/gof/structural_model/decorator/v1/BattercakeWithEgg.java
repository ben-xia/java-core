package com.ben.java.gof.structural_model.decorator.v1;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/2
 */
public class BattercakeWithEgg extends Battercake{
    @Override
    protected String getMsg() {
        return super.getMsg()+",加1个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice()+1;
    }
}
