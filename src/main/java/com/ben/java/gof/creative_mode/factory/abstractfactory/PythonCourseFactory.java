package com.ben.java.gof.creative_mode.factory.abstractfactory;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/14
 */
public class PythonCourseFactory extends CourseFactory{
    @Override
    protected INote createNote() {
        super.init();
        return new PythonNote();
    }

    @Override
    protected IVideo createVideo() {
        super.init();
        return new PythonVideo();
    }
}
