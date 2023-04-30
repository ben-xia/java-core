package com.ben.java.gof.structural_model.flyweight.genel;

/**
 * 抽象的享元（共享元素）角色
 */
public interface IFlyweight {
    //    extrinsicState: 外部状态
    void operation(String extrinsicState);
}
