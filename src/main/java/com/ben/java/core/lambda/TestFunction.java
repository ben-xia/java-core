package com.ben.java.core.lambda;

import org.junit.Test;

import java.util.function.*;

/**
 * @author ben-xia
 * @date 2021/05/28
 * @Description TODO
 **/
public class TestFunction {
    @Test
    public void functionTest01() {
        Function<Integer, Integer> incr1 = x -> x + 1;
        Function<Integer, Integer> multiply = x -> x * 2;

        int x = 2;
        System.out.println("f(x)=x+1,when x=" + x + ",f(x)=" + incr1.apply(x));
        System.out.println("f(x)=x+1,g(x)=2x,when x=" + x + ",f(g(x))=" + incr1.compose(multiply).apply(x));
        System.out.println("f(x)=x+1,g(x)=2x,when x=" + x + ",g(f(x))=" + incr1.andThen(multiply).apply(x));
        System.out.println("compose vs andThen:f(g(x))" + incr1.compose(multiply).apply(x) + "," + multiply.andThen(incr1).apply(x));

    }

    @Test
    public void functionTest02() {
        Function<Integer, Function<Integer, Integer>> makeAdder = z -> y -> z + y;
        Function<Integer, Integer> add1 = makeAdder.apply(1);  //y=1

        Integer x = 2;
        System.out.println("f(x)=x+1,when x=" + x + ",f(x)=" + add1.apply(x));
        Function<Integer, Integer> add5 = makeAdder.apply(5); //y=5
        System.out.println("f(x)=x+5,when x=" + x + ",f(x)=" + add5.apply(x));

    }

    @Test
    public void functionTest03() {
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        System.out.println(multiply.apply(3, 20));

    }

    @Test
    public void functionTest04() {
        UnaryOperator<Integer> add = x -> x + 1;
        System.out.println(add.apply(1));

        BinaryOperator<Integer> addxy = (x, y) -> x + y;
        System.out.println(addxy.apply(3, 5));

        BinaryOperator<Integer> min = BinaryOperator.minBy((o1, o2) -> o1 - o2);
        System.out.println(min.apply(100, 200));
        BinaryOperator<Integer> max = BinaryOperator.maxBy((o1, o2) -> o1 - o2);
        System.out.println(max.apply(100, 200));

    }

    @Test
    public void functionTest05() {
        Consumer<Integer> consumer = System.out::println;  //方法引用
        consumer.accept(100);

        Consumer<String> consumer1 = new TestFunction()::test;
        consumer1.accept("John");

        Supplier<TestFunction> supplier = TestFunction::new;
        System.err.println(supplier.get());

    }
    public void test(String msg){
        System.out.println("hello " + msg);
    }

}
















