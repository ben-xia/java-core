package com.ben.java.core.innerclass;

/**
 * @author ben-xia
 * @date 2020/03/29
 * @Description  https://www.cnblogs.com/wuhenzhidu/p/anonymous.html
 * 匿名内部类(JDK8的Lambda基本可以取代其使用): 匿名内部类不能访问外部类未加final修饰的变量（注意：JDK1.8即使没有用final修饰也可以访问）；
 **/
public class AnonymousInner {
    public int x = 0;

    interface FirstLevel {
        void methodInFirstLevel(int x);
    }

    FirstLevel firstLevel = new FirstLevel() {

        public int x = 1;
//        匿名内部类中不能定义静态属性、方法；　
//        public static String str = "Hello World";   // 编译报错
//        public static void aa() {        // 编译报错
//        }

        @Override
        public void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("AnonymousInner.this.x = " + AnonymousInner.this.x);
        }
    };

    public static void main(String... args) {
        AnonymousInner st = new AnonymousInner();
        FirstLevel fl = st.firstLevel;
        fl.methodInFirstLevel(23);
    }
}