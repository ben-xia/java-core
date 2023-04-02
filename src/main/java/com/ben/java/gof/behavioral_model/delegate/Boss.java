package com.ben.java.gof.behavioral_model.delegate;

public class Boss {
    void command(String task, IEmployee iEmployee){
        iEmployee.doTask(task);
    }
}
