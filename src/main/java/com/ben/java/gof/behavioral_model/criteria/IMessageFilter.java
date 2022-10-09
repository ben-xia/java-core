package com.ben.java.gof.behavioral_model.criteria;


/**
 * 类功能说明:   告警消息过滤器
 */
public abstract class IMessageFilter implements Comparable<IMessageFilter>
{
    public int priority()
    {
        return 0;
    }

    public abstract boolean doFilter(Message msg);

    public int compareTo(IMessageFilter arg0)
    {
        return priority() - arg0.priority();
    }


}