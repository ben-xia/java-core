package com.ben.java.gof.behavioral_model.criteria;

/**
 * 类功能说明:   告警消息
 */
public class Message
{
    private String name;

    private int hour;

    private int type;

    private int severity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    @Override
    public String toString() {
        return "Message [name=" + name + ", hour=" + hour + ", type=" + type
                + ", severity=" + severity + "]";
    }
}