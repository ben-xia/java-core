package com.ben.java.gof.creative_mode.factory.abstractfactory;

/**
 * @author: ben.xia
 * @desc:  课程包括: 笔记和视频
 * @date: 2023/5/14
 */
public abstract class CourseFactory {
    public void init(){
        System.out.println("初始化基础数据");
    }

    protected abstract INote createNote();
    protected abstract IVideo createVideo();
}
