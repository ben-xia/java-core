package com.ben.java.gof.behavioral_model.observer;

public class ConcreteSubject extends Subject {
    /*交易状态*/
    private String status;

    public String getStatus() {
        return status;
    }

    /*交易或者取消交易 */
    public void setStatus(String status) {
        this.status = status;
        notifyobserver();

    }

    @Override
    public void add(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyobserver() {
        /**
         * 这说明各个观察者是依次获得的同步通知，如果上一个观察者处理太慢，会导致下一个观察者不能及时获得通知。
         * 此外，如果观察者在处理通知的时候，发生了异常，还需要被观察者处理异常，才能保证继续通知下一个观察者。
         */
//        for (Observer observer : observerList) {
//            observer.update(this, this.status);
//        }

        //并行处理
        observerList.parallelStream().forEach(observer -> observer.update(this, this.status));

    }


}
