package com.ben.java.gof.structural_model.adapter.genel.classadapter;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/1
 */
public class ClassadapterTest {
    public static void main(String[] args) {
        // spring中注入DC5
        DC5 dc5 = new PowerAdapter();
        dc5.output5V();
    }
}
