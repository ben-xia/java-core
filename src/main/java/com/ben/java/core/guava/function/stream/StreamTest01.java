package com.ben.java.core.guava.function.stream;

import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ben-xia
 * @date 2020/03/12
 * @Description https://www.jianshu.com/p/0c07597d8311
 **/
public class StreamTest01 {
    class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }
    }
    @Test
    public void testStream01() {

        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        IntStream.range(1, 4)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);

        Stream.of(1.0, 2.0, 3.0)
                .mapToInt(Double::intValue)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);

        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> { //最终操作且anyMatch匹配上了结束整个Stream
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });
    }

    @Test
    public void testStream02() {
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");  //中间操作且匹配上了才会继续往下执行;
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

    }

    @Test
    public void testStream03() {
        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        streamSupplier.get().anyMatch(new Predicate<String>() {
            @Override
            public boolean apply(String s) {
                return true;
            }
        });   // ok
        streamSupplier.get().noneMatch(s -> true);  // ok

    }


  @Test //Collect（收集）是一种是十分有用的最终操作，它可以把stream中的元素转换成另外一种形式，比如；list，set，map。
    public void testStream04() {


      List<Person> persons =
              Arrays.asList(
                      new Person("Max", 18),
                      new Person("Peter", 23),
                      new Person("Pamela", 23),
                      new Person("David", 12));
      List<Person> filtered =
              persons
                      .stream()
                      .filter(p -> p.name.startsWith("P"))
                      .collect(Collectors.toList());

      System.out.println(filtered);    // [Peter, Pamela]


      Map<Integer, List<Person>> personsByAge = persons
              .stream()
              .collect(Collectors.groupingBy(p -> p.age));

      personsByAge
              .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

// age 18: [Max]
// age 23: [Peter, Pamela]
// age 12: [David]

      IntSummaryStatistics ageSummary =
              persons
                      .stream()
                      .collect(Collectors.summarizingInt(p -> p.age));

      System.out.println(ageSummary);
// IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000, max=23}

    }






}
