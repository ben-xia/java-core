package com.ben.java.core.innerclass;

/**
 * @author ben-xia
 * @date 2021/04/23
 * @Description 类调类, 成员调成员,静态调静态
 **/
public class TestInnerClass {

    public static void main(String[] args) {
        OutsideClass.StaticInsideClass.staticMethod("OutsideClass.StaticInsideClass.staticMethod(methodName)");
        new OutsideClass().outsideMethod("【一般类的非静态方法】 调用");
        new OutsideClass.StaticInsideClass();

        new OutsideClass.StaticInsideClass().insideMethod("【一般类的静态方法】 调用");
        new TestInnerClass().test();
    }

    public void test() {
        OutsideClass.StaticInsideClass.staticMethod(new String("test()"));
        new OutsideClass.StaticInsideClass().insideMethod("【一般类的一般方法】 调用");
    }
}

class OutsideClass {
    String data = "內部类別";
    /**
     * 相当于静态成员, 静态成员本身可以构造;
     */
    static class StaticInsideClass {

        // 静态内部类的构造方法
        public StaticInsideClass() {
            System.out.println("静态内部类的【构造函数】");
        }

        public static void staticMethod(String methodName) {
            System.out.println(methodName + "调用静态内部类 的 静态方法。——————可行！！！");

            new OutsideClass().outsideMethod("【静态内部类 的 静态方法】 调用");
            new StaticInsideClass().insideMethod("【静态内部类 的 静态方法】 调用");
        }

        public void insideMethod(String who) {
            System.out.println(who + "静态内部类 中，非静态方法。——————可行！！！");
        }
    }

    //成员内部类
    public class InsideClass {
//         String data = "內部类別";
        private static final String name = "Inner-data";

        public String getOuterData() {
            return OutsideClass.this.data;
        }
    }

    /**
     * 包含两个方法的HelloWorld接口
     */
    interface HelloWorld {
        public void greet();
        public void greetSomeone(String someone);
    }
    public void sayHello() {

        // 1、局部类EnglishGreeting实现了HelloWorld接口
        class EnglishGreeting implements OutsideClass.HelloWorld {
            String name = "world";
            public void greet() {
                greetSomeone("world");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }

        OutsideClass.HelloWorld englishGreeting = new EnglishGreeting();

        // 2、匿名类实现HelloWorld接口
        OutsideClass.HelloWorld frenchGreeting = new OutsideClass.HelloWorld() {
            String name = "tout le monde";
            public void greet() {
                greetSomeone("tout le monde");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };

        // 3、匿名类实现HelloWorld接口
        OutsideClass.HelloWorld spanishGreeting = new OutsideClass.HelloWorld() {
            String name = "mundo";
            public void greet() {
                greetSomeone("mundo");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }
        };

        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
        spanishGreeting.greet();
    }

    public void outsideMethod(String who) {
        System.out.println(who + "外部类 的 非静态方法。——————可行！！！");
    }
}
