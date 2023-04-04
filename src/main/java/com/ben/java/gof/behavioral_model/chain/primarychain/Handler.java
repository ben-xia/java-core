package com.ben.java.gof.behavioral_model.chain.primarychain;


public abstract class Handler {
    protected Handler nextHandle;

    protected void setNextHandle(Handler nextHandle){
        this.nextHandle = nextHandle;
    }

    protected abstract void doHandle(User user);
}
