package com.ben.java.gof.structural_model.bridge;

/**
 * @author ben-xia
 * @date 2021/04/24
 * @Description TODO
 **/
public class Client {
    public static void main(String[] args) {
        RefinedCar car = new BossCar(new HybridEngine());
        car.drive();
    }
}
