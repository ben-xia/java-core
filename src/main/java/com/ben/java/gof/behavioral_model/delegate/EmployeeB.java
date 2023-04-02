package com.ben.java.gof.behavioral_model.delegate;

/**
 * 员工B
 */
public class EmployeeB implements IEmployee{
    private String goodAt="design";
    @Override
    public void doTask(String task) {
        System.out.println("EmployeeB擅长"+goodAt+",他正在处理"+task);
    }
}
