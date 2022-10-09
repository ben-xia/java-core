package com.ben.java.gof.behavioral_model.criteria;

/**
 *
 * 类功能说明:   时间过滤
 */
public class TimeFilter extends IMessageFilter
{

    public int priority()
    {
        return 1;
    }

    public boolean doFilter(Message msg)
    {
        if(msg.getHour() < 8 || msg.getHour() > 17)
        {
            System.out.println("Time filter false, message is " + msg);
            return false;
        }
        System.out.println("Time filter true, message is " + msg);
        return true;
    }

}