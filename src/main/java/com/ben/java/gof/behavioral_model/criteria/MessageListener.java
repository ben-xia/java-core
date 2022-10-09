package com.ben.java.gof.behavioral_model.criteria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 类功能说明:   告警消息监听
 */
public class MessageListener {
    public static void main(String[] args) {
        MessageListener listener = new MessageListener();
        Message msg = new Message();
        msg.setHour(12);
        msg.setName("coshaho");
        msg.setType(5);
        msg.setSeverity(3);
        listener.listen(msg);
    }

    public void listen(Message msg) {
        excute(msg);
    }

    private boolean excute(Message msg) {
        IMessageFilter timeFilter = new TimeFilter();
        IMessageFilter typeFilter = new TypeFilter();
        IMessageFilter serverityFilter = new ServerityFilter();
        List<IMessageFilter> filters = new ArrayList<>();
        filters.add(timeFilter);
        filters.add(typeFilter);
        filters.add(serverityFilter);

        Collections.sort(filters);
        for (IMessageFilter filter : filters) {
            if (!filter.doFilter(msg)) {
                return false;
            }
        }
        return true;
    }
}
