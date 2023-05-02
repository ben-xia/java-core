package com.ben.java.gof.structural_model.adapter.genel.objectadapter;

/**
 * @author: ben.xia
 * @desc:  被适配者,原有的类或者接口
 * @date: 2023/5/1
 */
public class AC220 {
    public int outputAC220V() {
        int output = 220;
        System.out.println("输出电压:" + output + "V");
        return output;
    }
}
