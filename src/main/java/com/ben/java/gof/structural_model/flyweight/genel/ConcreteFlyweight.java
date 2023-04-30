package com.ben.java.gof.structural_model.flyweight.genel;

/**
 * 具体享元角色[反复创建和销毁的对象】
 */
public class ConcreteFlyweight implements IFlyweight{
    //    intrinsicState: 内部状态
    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println("Object address:" + System.identityHashCode(this));
        System.out.println("IntrinsicState:" + this.intrinsicState);
        System.out.println("ExtrinsicState:" + extrinsicState);
    }
}
