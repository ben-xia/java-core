package com.ben.java.gof.structural_model.adapter.genel.classadapter;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/1
 */
public class PowerAdapter extends AC220 implements DC5 {
    @Override
    public int output5V() {
        int ac220V = outputAC220V();
        int dc5v = ac220V / 44;
        System.out.println("使用Adapter输入AC:" + ac220V + "V,输出DC:" + dc5v + "V");
        return dc5v;
    }
}
