package com.ben.java.gof.structural_model.flyweight.genel;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂[一般都是单例的]
 */
public class FlyweightFactory {
    private static Map<String, IFlyweight> pool = new HashMap<>();

    // 因为内部状态具有不变性，因此作为缓存的键
    public static IFlyweight getIFlyweight(String intrinsicState) {
        if (!pool.containsKey(intrinsicState)) {
            IFlyweight flyweight = new ConcreteFlyweight(intrinsicState);
            pool.put(intrinsicState, flyweight);
            return flyweight;
        }
        return pool.get(intrinsicState);
    }
}
