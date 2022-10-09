package com.ben.java.gof.structural_model.bridge;

/**
 * @author ben-xia
 * @date 2021/04/24
 * @Description TODO
 **/
public abstract class RefinedCar extends Car {
    public RefinedCar(Engine engine) {
        super(engine);
    }

    public void drive() {
        this.engine.start();
        System.out.println("Drive " + getBrand() + " car...");
    }

    public abstract String getBrand();
}
