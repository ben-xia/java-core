package com.ben.java.gof.structural_model.bridge;

/**
 * @author ben-xia
 * @date 2021/04/24
 * @Description TODO
 **/
public class BossCar extends RefinedCar {
    public BossCar(Engine engine) {
        super(engine);
    }

    public String getBrand() {
        return "Boss";
    }
}
