package com.ben.java.gof.structural_model.decorator.v2;

/**
 * @author: ben.xia
 * @desc:  装饰者是被装饰者的子类,且装饰者持有被装饰者的引用
 * @date: 2023/5/2
 */
public class BattercakeV2Decorator extends BattercakeV2 {
    public BattercakeV2 battercakeV2;

    public BattercakeV2Decorator(BattercakeV2 battercakeV2) {
        this.battercakeV2 = battercakeV2;
    }

    @Override
    protected String getMsg() {
        return this.battercakeV2.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.battercakeV2.getPrice();
    }
}
