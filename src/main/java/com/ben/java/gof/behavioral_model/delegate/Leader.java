package com.ben.java.gof.behavioral_model.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * 团队领导
 */
public class Leader implements IEmployee{
    // 任务和员工的映射关系
    private Map<String, IEmployee> iEmployeeMap = new HashMap<>();

    public Leader() {
        iEmployeeMap.put("task_coding", new EmployeeA());
        iEmployeeMap.put("task_design", new EmployeeB());
    }

    @Override
    public void doTask(String task) {
       if (!iEmployeeMap.containsKey(task)){
           System.out.println("task:\t" + task+",已经超过我能力范围了,我无法完成");
           return;
       }
        iEmployeeMap.get(task).doTask(task);
    }
}
