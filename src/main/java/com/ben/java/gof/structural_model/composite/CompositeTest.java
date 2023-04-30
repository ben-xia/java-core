package com.ben.java.gof.structural_model.composite;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/4/30
 */
public class CompositeTest {

    public static void main(String[] args) {
        File qq = new File("QQ.exe");
        File wx = new File("WX.exe");

        Folder office = new Folder("办公软件", 2);
        File word = new File("word.exe");
        File ppt = new File("ppt.exe");
        File excel = new File("excel.exe");
        office.add(word);
        office.add(ppt);
        office.add(excel);

        Folder root = new Folder("D盘", 1);
        root.add(qq);
        root.add(wx);
        root.add(office);

        root.show();
    }
}
