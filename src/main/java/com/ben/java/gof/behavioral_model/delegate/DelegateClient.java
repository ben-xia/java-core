package com.ben.java.gof.behavioral_model.delegate;

public class DelegateClient {
    public static void main(String[] args) {
        new Boss().command("task_coding",new Leader());
        new Boss().command("task_design",new Leader());
        new Boss().command("task_xxxxxx",new Leader());
    }
}
