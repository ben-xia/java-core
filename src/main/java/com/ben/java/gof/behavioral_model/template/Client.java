package com.ben.java.gof.behavioral_model.template;

/**
 * @author ben-xia
 * @date 2019/10/27
 * @Description TODO
 **/
public class Client {
    public static void main(String[] args) {
        //模板模式
        HummerH2Model hummerH2Model = new HummerH2Model();
        HummerH1Model hummerH1Model = new HummerH1Model();
        hummerH2Model.run();
        hummerH1Model.setAlarm(false);
        hummerH1Model.run();

        //策略模式 + 模板模式
        Context context = new Context();
        context.run();

    }
}
