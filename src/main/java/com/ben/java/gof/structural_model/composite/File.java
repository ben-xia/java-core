package com.ben.java.gof.structural_model.composite;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/4/30
 */
public class File extends Direcotry{
    public File(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.print(this.name);
    }
}
