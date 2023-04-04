package com.ben.java.gof.behavioral_model.chain.builderchain;


import com.ben.java.gof.behavioral_model.chain.builderchain.User;

public abstract class Handler<T> {
    protected Handler nextHandle;

    protected void setNextHandle(Handler nextHandle) {
        this.nextHandle = nextHandle;
    }

    protected abstract void doHandle(User user);

    public static class Builder<T> {
        public Handler<T> header;
        public Handler<T> tail;

        public Builder<T> addHandle(Handler<T> handler) {
            if (header==null){
                this.header=this.tail=handler;
                return this;
            }
            tail.nextHandle=handler; //当第二个handle进来是,header和tail的nextHandle都指向了它,此处是关键;
            tail=handler;

            return this;
        }

        public Handler<T> builder() {
            return this.header;  // 返回链表的头节点
        }
    }
}
