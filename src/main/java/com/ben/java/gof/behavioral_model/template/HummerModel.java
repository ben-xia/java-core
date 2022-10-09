package com.ben.java.gof.behavioral_model.template;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 * Hummer Model是悍马车辆模型的意思，不是悍马美女车模
 *
 * (*****钩子方法)模板方法模式就是在模板方法中按照一定的规则和顺序调用基本方法;
 *
 * 具体到我们上面那个例子就是run 方法按照规定的顺序(先调用start,然后再调用engineBoom，再调用
 * alarm，最后调用stop)调用本类的其他方法，并且由isAlarm 方法的返回值确定run 中的执行顺序变更
 */
public abstract class HummerModel {
    /*
     * 首先，这个模型要能够被发动起来，别管是手摇发动，还是电力发动，反正
     * 是要能够发动起来，那这个实现要在实现类里了
     */
    protected abstract void start();

    //能发动，那还要能停下来，那才是真本事
    protected abstract void stop();

    //喇叭会出声音，是滴滴叫，还是哔哔叫
    protected abstract void alarm();

    //引擎会轰隆隆的响，不响那是假的
    protected abstract void engineBoom();
    //那模型应该会跑吧，别管是人推的，还是电力驱动，总之要会跑

     public final void run() {
        //先发动汽车
        this.start();
        //引擎开始轰鸣
        this.engineBoom();
        //喇嘛想让它响就响，不想让它响就不响
        if (this.isAlarm()) {
            this.alarm();
        }
        //到达目的地就停车
        this.stop();
    }

    //钩子方法，默认喇叭是会响的
    protected boolean isAlarm() {
        return true;
    }
}