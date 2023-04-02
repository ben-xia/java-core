package com.ben.java.gof.behavioral_model.delegate;

/**
 * 员工A
 */
public class EmployeeA implements IEmployee{
    private String goodAt="coding";
    @Override
    public void doTask(String task) {
        System.out.println("EmployeeA擅长"+goodAt+",他正在处理"+task);
    }
}
