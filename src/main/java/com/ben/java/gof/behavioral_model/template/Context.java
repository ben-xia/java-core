package com.ben.java.gof.behavioral_model.template;

/**
 * @author ben-xia
 * @date 2019/11/10
 * @Description 策略模式 + 模板模式  的组合
 **/
public class Context {
    //默认策略
    private HummerModel hummerModel = new HummerH1Model();

    public void setContext(HummerModel hummerH1Model) {
        this.hummerModel = hummerH1Model;
    }

    public void run() {
        hummerModel.run();
    }
}
