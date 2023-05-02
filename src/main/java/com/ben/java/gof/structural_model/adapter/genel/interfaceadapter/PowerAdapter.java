package com.ben.java.gof.structural_model.adapter.genel.interfaceadapter;

import com.ben.java.gof.structural_model.adapter.genel.objectadapter.AC220;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/1
 */
public class PowerAdapter implements DC {
    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int output5V() {
        int ac220V = ac220.outputAC220V();
        int dc5v = ac220V / 44;
        System.out.println("使用Adapter输入AC:" + ac220V + "V,输出DC:" + dc5v + "V");
        return dc5v;
    }

    @Override
    public int output12V() {
        return 0;
    }

    @Override
    public int output24V() {
        return 0;
    }

    @Override
    public int output36V() {
        return 0;
    }
}
