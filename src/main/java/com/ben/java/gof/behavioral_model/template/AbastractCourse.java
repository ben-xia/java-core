package com.ben.java.gof.behavioral_model.template;

public abstract class AbastractCourse {

    protected boolean checkFomeworkFlag=false;

    public void setCheckFomeworkFlag(boolean checkFomeworkFlag) {
        this.checkFomeworkFlag = checkFomeworkFlag;
    }

    /**
     * 模板方法
     */
    public final void templateOfCourse(){
        // 1. 备课
        preCourse();
        // 2. 上课
        courseing();
        // 3. 提问
        question();
        // 4. 布置课后作业
           homework();
        // 5.是否要检查课后作业
        if (needCheckHomework()){
            checkHomework();
        }
    }

    protected abstract void checkHomework() ;

    protected void homework() {
        System.out.println("正在布置课后作业");

    }

    protected void question() {
        System.out.println("现在是提问环节");

    }

    protected void courseing() {
        System.out.println("正在上课中");

    }

    protected void preCourse() {
        System.out.println("正在备课中");
    }

    // 钩子方法, 勾住了就会执行特定方法
    protected boolean needCheckHomework(){
       return this.checkFomeworkFlag;
    }


}
