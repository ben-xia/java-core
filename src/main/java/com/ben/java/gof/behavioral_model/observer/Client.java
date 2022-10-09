package com.ben.java.gof.behavioral_model.observer;

public class Client {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver();
        Observer observer2 = new ConcreteObserver();
        Observer observer3 = new ConcreteObserver();
        Observer observer4 = new ConcreteObserver();
        subject.add(observer1);
        subject.add(observer2);
        subject.add(observer3);
        subject.add(observer4);

        ((ConcreteSubject) subject).setStatus("true");
//        System.out.println(((ConcreteObserver) observer1).getObserverStatus());
//        System.out.println(((ConcreteObserver) observer2).getObserverStatus());
//        System.out.println(((ConcreteObserver) observer3).getObserverStatus());
//        System.out.println(((ConcreteObserver) observer4).getObserverStatus());
//
//        System.out.println(((ConcreteObserver) observer1).getObserverStatus());

    }
}
