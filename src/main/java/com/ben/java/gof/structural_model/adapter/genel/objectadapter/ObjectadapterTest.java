package com.ben.java.gof.structural_model.adapter.genel.objectadapter;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/1
 */
public class ObjectadapterTest {
    public static void main(String[] args) {
        DC5 dc5 = new PowerAdapter(new AC220());
        dc5.output5V();
    }
}
