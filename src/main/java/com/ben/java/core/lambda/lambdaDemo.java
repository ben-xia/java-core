package com.ben.java.core.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author ben-xia
 * @date 2021/05/28
 * @Description TODO
 **/
public class lambdaDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("functionTest--------");
        functionTest();
        /*注意此用法: 此时functionTest会在一个新的Thread中运行*/
        ThreadUtils.addShutdownHook(lambdaDemo::functionTest);
        System.out.println("consumerTest--------");
        consumerTest();
        System.out.println("predicateTest--------");
        predicateTest();

        distinctPrimarySum("1","2","3","4","5","6","7","8","9");
    }

    // 第二个参数是Function接口
    public static String validInput(String name, Function<String, String> function) {
        return function.apply(name);
    }

    /**
     * Function接口的使用示例
     */
    public static void functionTest() {
        String name = "";
        String name1 = "12345";
        System.out.println(validInput(name, inputStr -> inputStr.isEmpty() ? "名字不能为空" : inputStr));
        System.out.println(validInput(name1, inputStr -> inputStr.length() > 3 ? "名字过长" : inputStr));
    }

    // 第二个参数是Consumer接口
    public static void validInput2(String name, Consumer<String> function) {
        function.accept(name);
    }

    /**
     * Consumer接口的使用示例
     */
    public static void consumerTest() {
        String name = "";
        String name1 = "12345";

        validInput2(name, inputStr -> System.out.println(inputStr.isEmpty() ? "名字不能为空" : "名字正常"));
        validInput2(name1, inputStr -> System.out.println(inputStr.isEmpty() ? "名字不能为空" : "名字正常"));

    }

    // 第二个参数是Predicate接口
    public static boolean validInput3(String name, Predicate<String> function) {
        return function.test(name);
    }

    /**
     * Predicate接口使用示例
     */
    public static void predicateTest() {
        String name = "";
        String name1 = "12";
        String name2 = "12345";

        System.out.println(validInput3(name, inputStr -> !inputStr.isEmpty() && inputStr.length() <= 3));
        System.out.println(validInput3(name1, inputStr -> !inputStr.isEmpty() && inputStr.length() <= 3));
        System.out.println(validInput3(name2, inputStr -> !inputStr.isEmpty() && inputStr.length() <= 3));

    }

    // 给出一个String类型的数组，求其中所有不重复素数的和
    public static void distinctPrimarySum(String... numbers) {
        List<String> l = Arrays.asList(numbers);
        int sum = l.stream()
                .map(e -> new Integer(e))
//                .filter(e -> Primes.isPrime(e))
                .distinct()
                .reduce(0, (x, y) -> x + y); // equivalent to .sum()
        System.out.println("distinctPrimarySum result is: " + sum);
    }

}
