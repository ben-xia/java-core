package com.ben.java.gof.creative_mode.factory.factorymethod;

import com.ben.java.gof.creative_mode.factory.simplefactory.ICourse;
import org.slf4j.ILoggerFactory;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/14
 */
public class FactorymethodTest {
    public static void main(String[] args) {
        ICourseFactory javaFactory = new JavaCourseFactory();
        ICourse course = javaFactory.create();
        course.record();

        ICourseFactory pythonFactory = new PythonCourseFactory();
        course = pythonFactory.create();
        course.record();


    }
}
