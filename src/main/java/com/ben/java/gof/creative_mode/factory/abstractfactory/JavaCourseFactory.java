package com.ben.java.gof.creative_mode.factory.abstractfactory;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/14
 */
public class JavaCourseFactory extends CourseFactory{

    @Override
    protected INote createNote() {
        super.init();
        return new JavaNote();
    }

    @Override
    protected IVideo createVideo() {
        super.init();
        return new JavaVideo();
    }
}
