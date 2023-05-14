package com.ben.java.gof.creative_mode.factory.simplefactory.v1;

import com.ben.java.gof.creative_mode.factory.simplefactory.ICourse;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/14
 */
public class SimplefactoryV1Test {
    public static void main(String[] args) {
        //  ICourse java =new JavaCourse("java");
        //  ICourse python =new PythonCourse("python");

        //new JavaCourse("java") | new PythonCourse("python") 可以提炼成一个工厂方法
        //new CourseFactory() : 工厂类可以设计成单例
        ICourse java = new CourseFactoryV1().createv1("java");
        java.record();
    }
}
