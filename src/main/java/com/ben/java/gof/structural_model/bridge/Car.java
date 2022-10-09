package com.ben.java.gof.structural_model.bridge;

/**
 * @author ben-xia
 * @date 2021/04/24
 * @Description TODO
 **/
public abstract class Car {
    // 引用Engine:
    protected Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public abstract void drive();
}
