package com.ben.java.gof.creative_mode.factory.abstractfactory;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/14
 */
public class AbstractfactoryTest {
    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        courseFactory.createNote().edit();
        courseFactory.createVideo().record();
    }
}
