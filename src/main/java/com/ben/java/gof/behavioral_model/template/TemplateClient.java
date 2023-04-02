package com.ben.java.gof.behavioral_model.template;

public class TemplateClient {
    public static void main(String[] args) {
        JavaCourse javaCourse = new JavaCourse();
        javaCourse.templateOfCourse();
        System.err.println("_____________________________________");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PythonCourse pythonCourse = new PythonCourse();
        pythonCourse.setCheckFomeworkFlag(true);
        pythonCourse.templateOfCourse();
    }
}
