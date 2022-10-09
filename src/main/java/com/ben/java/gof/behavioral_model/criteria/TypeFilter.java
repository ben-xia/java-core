package com.ben.java.gof.behavioral_model.criteria;

/**
 *  类功能说明:   类型过滤
 */
public class TypeFilter extends IMessageFilter{

    public int priority()
    {
        return 3;
    }

    public boolean doFilter(Message msg) {

        if(msg.getType() < 3)
        {
            System.out.println("Type filter false, message is " + msg);
            return false;
        }
        System.out.println("Type filter true, message is " + msg);
        return false;
    }



}