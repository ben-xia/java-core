package com.ben.java.gof.behavioral_model.strategy.v2;

import com.ben.java.gof.behavioral_model.strategy.v1.BackDoor;
import com.ben.java.gof.behavioral_model.strategy.v1.BlockEnemy;
import com.ben.java.gof.behavioral_model.strategy.v1.GivenGreenLight;
import com.ben.java.gof.behavioral_model.strategy.v1.IStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: ben.xia
 * @desc: 简单工厂
 * @date: 2023/5/2
 */
public class StrategyFactory {
    /**
     * 享元
     */
    private static  Map<String, IStrategy> pool = new HashMap<>();

    /**
     * 也可以直接维护到数据库
     */
    static {
        pool.put(StrategyKey.BACKDOOR, new BackDoor());
        pool.put(StrategyKey.BLOCKENEMY, new BlockEnemy());
    }

    private static final IStrategy EMPTY= new GivenGreenLight();

    /**
     * 单例
     */
    private StrategyFactory() {
    }

    /**
     * @param name
     * @return
     */
    public static IStrategy getIStrategy(String name){
        IStrategy iStrategy = pool.get(name);
        if (null==iStrategy){
            iStrategy=EMPTY;
        }
        return iStrategy;
    }

    private interface StrategyKey{
        String GIVENGREENLIGHT="givengreenlight";
        String BACKDOOR="backdoor";
        String BLOCKENEMY="blockenemy";
    }

    public static Set<String> getStrategyKey(){
        return pool.keySet();
    }

}
