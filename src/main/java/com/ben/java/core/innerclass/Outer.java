package com.ben.java.core.innerclass;

/**
 * 当inner class（内部类）必顺使用到outer class（外部类）的this instance（实例）时，
 * 或者匿名内部类要使用外部类的实例时,必须使用Class.this指代外部类的实例;
 *
 * @author Administrator
 */
class Outer {
    // String data = "外部类別";
    private String data;

    public Outer(String data) {
        super();
        this.data = data;
    }

    //成员内部类
    public class Inner {
        // String data = "內部类別";
        private static final String name = "Inner-data";

        public String getOuterData() {
            return Outer.this.data;
        }
    }

    //静态内部类
    public static class StaticInner {
        public static String str = "xxxx";
        public StaticInner() {
        }
    }

    public Inner returnInner() {
        return this.new Inner();
    }


    public static void main(String[] args) {
        Outer outer = new Outer("outer-data");
        //outer.new Inner() 此处内部类对象就自动获取了一个指向此外部类的引用[内部类和外部类关联了]
        String outerData = outer.new Inner().getOuterData();
        //没有Outer也行,比如JDK中的迭代器
        Inner returnInner = outer.returnInner();


        System.out.println(outerData);
        System.out.println(StaticInner.str);
        Outer.StaticInner staticInner = new StaticInner();
    }
}