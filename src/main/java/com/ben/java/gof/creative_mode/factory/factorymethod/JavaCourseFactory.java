package com.ben.java.gof.creative_mode.factory.factorymethod;

import com.ben.java.gof.creative_mode.factory.simplefactory.ICourse;
import com.ben.java.gof.creative_mode.factory.simplefactory.JavaCourse;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/14
 */
public class JavaCourseFactory  implements ICourseFactory{
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
