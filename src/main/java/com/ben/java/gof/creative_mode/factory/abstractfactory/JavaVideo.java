package com.ben.java.gof.creative_mode.factory.abstractfactory;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/14
 */
public class JavaVideo implements IVideo{
    @Override
    public void record() {
        System.out.println("java课程视频");
    }
}
