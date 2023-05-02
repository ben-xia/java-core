package com.ben.java.gof.structural_model.decorator.v2;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/2
 */
public class DecoratorTest {
    public static void main(String[] args) {
        BattercakeV2 battercakeV2 = new BaseBattercakeV2();
        System.out.println(battercakeV2.getMsg() + "," + battercakeV2.getPrice() + "元");

        battercakeV2 = new BattercakeV2Decorator(battercakeV2);
        System.out.println(battercakeV2.getMsg() + "," + battercakeV2.getPrice() + "元");

        battercakeV2 = new EggDecorator(battercakeV2);
        System.out.println(battercakeV2.getMsg() + "," + battercakeV2.getPrice() + "元");

        battercakeV2 = new SauageDecorator(battercakeV2);
        System.out.println(battercakeV2.getMsg() + "," + battercakeV2.getPrice() + "元");
    }
}
