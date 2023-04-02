package com.ben.java.gof.behavioral_model.template;

public class PythonCourse extends AbastractCourse{

    @Override
    protected void checkHomework() {
        System.out.println("PythonCourse需要检查课后作业");
    }
}
