package com.ben.java.gof.behavioral_model.observer.java;

public class javaObserverClient {
    public static void main(String[] args) {
        NewsPaper newsPaper = new NewsPaper();
        Reader reader = new Reader();
        reader.setName("老王");
        newsPaper.addObserver(reader);
        newsPaper.setContent("申报,申报");
    }
}
