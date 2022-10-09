package com.ben.java.gof.behavioral_model.criteria;

/**
 * 类功能说明:   级别过滤
 */
public class ServerityFilter extends IMessageFilter
{

    public int priority() {
        return 2;
    }

    public boolean doFilter(Message msg) {
        if(msg.getSeverity() == 0)
        {
            System.out.println("Severity filter false, message is " + msg);
            return false;
        }
        System.out.println("Severity filter true, message is " + msg);
        return true;
    }

}