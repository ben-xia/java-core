package com.ben.java.core.lambda;

/**
 * @author ben-xia
 * @date 2021/05/27
 * @Description TODO
 **/
public class Java8Tester3 {

    //Java8Tester3的成员变量
    String salutation = "Hello! ";

    public static void main(String args[]) {
        Java8Tester3 jt = new Java8Tester3();
        GreetingService greetService1 = message -> System.out.println(jt.salutation + message);
        greetService1.sayMessage("Runoob");
    }

    interface GreetingService {
        void sayMessage(String message);
    }

}
