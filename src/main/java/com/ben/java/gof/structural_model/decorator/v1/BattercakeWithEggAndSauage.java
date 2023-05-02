package com.ben.java.gof.structural_model.decorator.v1;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/2
 */
public class BattercakeWithEggAndSauage extends BattercakeWithEgg {
    @Override
    protected String getMsg() {
        return super.getMsg() + ",加1根香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
