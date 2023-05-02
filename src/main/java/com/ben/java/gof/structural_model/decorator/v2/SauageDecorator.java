package com.ben.java.gof.structural_model.decorator.v2;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/2
 */
public class SauageDecorator extends BattercakeV2Decorator {
    public SauageDecorator(BattercakeV2 battercakeV2) {
        super(battercakeV2);
    }

    @Override
    protected String getMsg() {
        return super.getMsg() + ",加1根香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
