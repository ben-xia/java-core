package com.ben.java.gof.structural_model.composite;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/4/30
 */
public abstract class Direcotry {
    protected String name;

    public Direcotry(String name) {
        this.name = name;
    }

    public abstract void show();
}
