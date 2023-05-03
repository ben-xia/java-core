package com.ben.java.gof.behavioral_model.strategy.v2;

import com.ben.java.gof.behavioral_model.strategy.v1.BlockEnemy;
import com.ben.java.gof.behavioral_model.strategy.v1.Context;
import com.ben.java.gof.behavioral_model.strategy.v1.GivenGreenLight;
import com.ben.java.gof.behavioral_model.strategy.v1.IStrategy;

import java.util.Set;

/**
 * @author ben-xia
 * @date 2019/10/23
 * @Description TODO
 **/
public class Client {
    public static void main(String[] args) {
        // 返回给页面所有的策略[如所有的支付方式:支付宝,微信,银联]
        Set<String> strategyKeys = StrategyFactory.getStrategyKey();

        //用户选择的key
        String selectKey="backdoor";

        IStrategy strategy = StrategyFactory.getIStrategy(selectKey);
        strategy.operate();
    }

}
