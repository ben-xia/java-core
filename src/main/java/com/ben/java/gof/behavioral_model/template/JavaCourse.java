package com.ben.java.gof.behavioral_model.template;

public class JavaCourse extends AbastractCourse{

    @Override
    protected void checkHomework() {
        System.out.println("JavaCourse需要检查课后作业");
    }
}
