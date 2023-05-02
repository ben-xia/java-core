package com.ben.java.gof.structural_model.decorator.v1;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/2
 */
public class Test {
    public static void main(String[] args) {
        Battercake battercake = new Battercake();
        System.out.println(battercake.getMsg() + "," + battercake.getPrice() + "元");
        battercake = new BattercakeWithEgg();
        System.out.println(battercake.getMsg() + "," + battercake.getPrice() + "元");

        battercake = new BattercakeWithEggAndSauage();
        System.out.println(battercake.getMsg() + "," + battercake.getPrice() + "元");
    }
}
