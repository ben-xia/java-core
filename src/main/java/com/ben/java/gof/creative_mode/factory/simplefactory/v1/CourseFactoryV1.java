package com.ben.java.gof.creative_mode.factory.simplefactory.v1;

import com.ben.java.gof.creative_mode.factory.simplefactory.ICourse;
import com.ben.java.gof.creative_mode.factory.simplefactory.JavaCourse;
import com.ben.java.gof.creative_mode.factory.simplefactory.PythonCourse;
import org.apache.commons.lang.StringUtils;

import java.util.Objects;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/14
 */
public class CourseFactoryV1 {
    /**
     * 传入类名
     * @param name
     * @return
     */
    public ICourse createv1(String name){
        if (name.equalsIgnoreCase("java")){
            return new JavaCourse();
        }else if (name.equalsIgnoreCase("python")){
            return new PythonCourse();
        }else {
            throw new RuntimeException("不支持录制" + name + "课程");
        }
    }

    /**
     * 传入类的全限定类名
     * @param className
     * @return
     */
    public ICourse createv2(String className) {
        // v1: 硬编码
//        if (name.equalsIgnoreCase("java")){
//            return new JavaCourse();
//        }else if (name.equalsIgnoreCase("python")){
//            return new PythonCourse();
//        }else {
//            throw new RuntimeException("不支持录制" + name + "课程");
//        }

        // v2: 通过反射
        try {
            if (StringUtils.isNotBlank(className)) {
                return (ICourse) Class.forName(className).newInstance();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // v3: 提前实例化所有的对象,放入缓存池[享元模式]
        // v4: 按需生产,先从缓存中去,如果没有在实例化


        return null;
    }

    /**
     * 传入Class类
     * @param clazz
     * @return
     */
    public ICourse createv3(Class clazz) {
        // v1: 硬编码
//        if (name.equalsIgnoreCase("java")){
//            return new JavaCourse();
//        }else if (name.equalsIgnoreCase("python")){
//            return new PythonCourse();
//        }else {
//            throw new RuntimeException("不支持录制" + name + "课程");
//        }

        // v2: 通过反射
//        try {
//            if (StringUtils.isNotBlank(className)) {
//                return (ICourse) Class.forName(className).newInstance();
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        // v3: 通过反射
        try {
            if (Objects.nonNull(clazz)){
                return (ICourse)clazz.newInstance();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }




        // v3: 提前实例化所有的对象,放入缓存池[享元模式]
        // v4: 按需生产,先从缓存中去,如果没有在实例化


        return null;
    }

    /**
     * 传入Class泛型类
     * @param clazz
     * @return
     */
    public ICourse createv4(Class<? extends ICourse> clazz) {
        // v1: 硬编码
//        if (name.equalsIgnoreCase("java")){
//            return new JavaCourse();
//        }else if (name.equalsIgnoreCase("python")){
//            return new PythonCourse();
//        }else {
//            throw new RuntimeException("不支持录制" + name + "课程");
//        }

        // v2: 通过反射[类名]
//        try {
//            if (StringUtils.isNotBlank(className)) {
//                return (ICourse) Class.forName(className).newInstance();
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

//        // v3: 通过反射[Class]
//        try {
//            if (Objects.nonNull(clazz)){
//                return (ICourse)clazz.newInstance();
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        // v4: 通过反射[泛型]
        try {
            if (Objects.nonNull(clazz)){
                return clazz.newInstance();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        // v3: 提前实例化所有的对象,放入缓存池[享元模式]
        // v4: 按需生产,先从缓存中去,如果没有在实例化


        return null;
    }
}
