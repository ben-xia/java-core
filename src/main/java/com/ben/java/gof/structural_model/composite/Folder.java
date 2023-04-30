package com.ben.java.gof.structural_model.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/4/30
 */
public class Folder extends Direcotry {
    private List<Direcotry> dirs;
    private Integer level;

    public Folder(String name, Integer level) {
        super(name);
        this.level = level;
        dirs = new ArrayList<>();
    }

    @Override
    public void show() {  //核心算法 -  递归
        for (Direcotry dir : dirs) {
            System.out.println(this.name);
            if (this.level != null) {
                for (int i = 0; i < level; i++) {
                    System.out.print("   ");
                }
                for (int i = 0; i < level; i++) {
                    if (i == 0) {
                        System.out.print("+");
                    }
                    System.out.print("-");
                }
            }
            dir.show();
        }

    }

    public boolean add(Direcotry dir) {
        return this.dirs.add(dir);
    }

    public boolean remove(Direcotry dir) {
        return this.dirs.remove(dir);
    }

    public Direcotry get(Integer index) {
        return this.dirs.get(index);
    }

}
