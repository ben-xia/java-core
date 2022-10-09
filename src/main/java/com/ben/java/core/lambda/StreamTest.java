package com.ben.java.core.lambda;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ben-xia
 * @date 2021/01/24
 * @Description TODO
 **/
public class StreamTest {

    @Test
    public void test01() {
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);

        // 遍历输出符合条件的元素
        list.stream().filter(x -> x > 6).forEach(System.out::println); //7,9,8
        // 匹配第一个
        Optional<Integer> findFirst = list.stream().filter(x -> x > 6).findFirst(); //7
        // 匹配任意（适用于并行流）
        Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny(); //7
        // 是否包含符合特定条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x < 6); //true
        System.out.println("匹配第一个值：" + findFirst.get());
        System.out.println("匹配任意一个值：" + findAny.get());
        System.out.println("是否存在大于6的值：" + anyMatch);
    }

    @Test
    public void test02() {
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd", "aeoujgsd");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的字符串：" + max.get());

    }


    @Test
    public void test03() {
        List<Integer> list = Arrays.asList(7, 6, 9, 4, 11, 6);

        // 自然排序
        Optional<Integer> max = list.stream().max(Integer::compareTo);  // Integer的compareTo的方法
        // 自定义排序
        Optional<Integer> max2 = list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("自然排序的最大值：" + max.get());
        System.out.println("自定义排序的最大值：" + max2.get());
    }


    @Test
    public void test04() {
        String[] strArr = {"abcd", "bcdd", "defde", "fTr"};
        List<String> strList = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());

        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> intListNew = intList.stream().map(x -> x + 3).collect(Collectors.toList());

        System.out.println("每个元素大写：" + strList);
        System.out.println("每个元素+3：" + intListNew);
    }

    @Test
    public void test05() {
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> listNew = list.stream().flatMap(s -> {
            // 将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        }).collect(Collectors.toList());

        System.out.println("处理前的集合：" + list);
        System.out.println("处理后的集合：" + listNew);
    }

    @Test
    public void test06() {
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
        // 求和方式1
        Optional<Integer> sum = list.stream().reduce((x, y) -> x + y);
        // 求和方式2
        Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
        // 求和方式3
        Integer sum3 = list.stream().reduce(0, Integer::sum);

        // 求乘积
        Optional<Integer> product = list.stream().reduce((x, y) -> x * y);

        // 求最大值方式1
        Optional<Integer> max = list.stream().reduce((x, y) -> x > y ? x : y);
        // 求最大值写法2
        Integer max2 = list.stream().reduce(1, Integer::max);

        System.out.println("list求和：" + sum.get() + "," + sum2.get() + "," + sum3);
        System.out.println("list求积：" + product.get());
        System.out.println("list求和：" + max.get() + "," + max2);
    }

    @Test
    public void test07() {
        String name = "";
        String name1 = "12345";
        System.out.println(validInput(name, inputStr -> inputStr.isEmpty() ? "名字不能为空" : inputStr));
        System.out.println(validInput(name1, inputStr -> inputStr.length() > 3 ? "名字过长" : inputStr));
    }

    public String validInput(String name, Function<String, String> function) {
        return function.apply(name);
    }


    @Test
    public void test08() {
        List<String> list = Arrays.asList("123", "456", "789", "1101", "212121121", "asdaa", "3e3e3e", "2321eew");
        List<String> l1 = list.stream().collect(Collectors.toCollection(LinkedList::new));
        List<String> l2 = list.stream().collect(Collectors.toList());
        Set<String> set = list.stream().collect(Collectors.toSet());
        System.out.println(l1); //[123, 456, 789, 1101, 212121121, asdaa, 3e3e3e, 2321eew]
        System.out.println(l2); //[123, 456, 789, 1101, 212121121, asdaa, 3e3e3e, 2321eew]
        System.out.println(set); //[123, 456, 789, 1101, 212121121, asdaa, 3e3e3e, 2321eew]
    }

    @Test
    public void test09() {
        List<String> list = Arrays.asList("123", "456", "789", "1101", "212121121", "asdaa", "3e3e3e", "2321eew");
        // 无参方法
        String s = list.stream().collect(Collectors.joining());
        System.out.println(s);//1234567891101212121121asdaa3e3e3e2321eew
        // 指定连接符
        String ss = list.stream().collect(Collectors.joining("-"));
        System.out.println(ss);//123-456-789-1101-212121121-asdaa-3e3e3e-2321eew
        // 指定连接符和前后缀
        String sss = list.stream().collect(Collectors.joining("-", "S", "E"));
        System.out.println(sss);//S123-456-789-1101-212121121-asdaa-3e3e3e-2321eewE
    }

    @Test
    public void test10() {
        List<String> list = Arrays.asList("123", "456", "789", "1101", "212121121", "asdaa", "3e3e3e", "2321eew");
        System.out.println(list.stream().collect(Collectors.maxBy((a, b) -> a.length() - b.length())));//Optional[212121121]
        System.out.println(list.stream().collect(Collectors.minBy((a, b) -> a.length() - b.length())));//Optional[123]
    }

    @Test
    public void test11() {
        List<String> list = Arrays.asList("123", "456", "789", "1101", "1", "12.56", "4321", "asdaa", "3e3e3e", "2321eew");
        Map<Integer, List<String>> s = list.stream().collect(Collectors.groupingByConcurrent(String::length));
        Map<Integer, List<String>> ss = list.stream().collect(Collectors.groupingByConcurrent(String::length, Collectors.toList()));
        Map<Integer, Set<String>> sss = list.stream().collect(Collectors.groupingBy(String::length, HashMap::new, Collectors.toSet()));
        Map<Integer, Set<String>> ssss = list.stream().collect(Collectors.groupingByConcurrent(String::length, ConcurrentHashMap::new, Collectors.toSet()));
        System.out.println(s.toString() + "\n" + ss.toString() + "\n" + sss.toString() + "\n" + ssss.toString());
    }

    @Test
    public void test12() {
        List<String> list = Arrays.asList("123", "456", "789", "1101", "1", "12.56", "4321", "asdaa", "3e3e3e", "2321eew");
        Map<String, String> map = list.stream().limit(3).collect(Collectors.toMap(e -> e.substring(0, 1), e -> e));
        Map<String, String> map1 = list.stream().collect(Collectors.toMap(e -> e.substring(0, 1), e -> e, (a, b) -> b));
        Map<String, String> map2 = list.stream().collect(Collectors.toConcurrentMap(e -> e.substring(0, 1), e -> e, (a, b) -> b, ConcurrentHashMap::new));
        System.out.println(map.toString() + "\n" + map1.toString() + "\n" + map2.toString());
    }


    @Test
    public void test13() {
        List<String> list = Arrays.asList("123", "456", "789", "1101", "212121121", "asdaa", "3e3e3e", "2321eew");
        IntSummaryStatistics intSummary = list.stream().collect(Collectors.summarizingInt(String::length));
        LongSummaryStatistics longSummary = list.stream().limit(4).collect(Collectors.summarizingLong(Long::valueOf));
        DoubleSummaryStatistics doubleSummary = list.stream().limit(3).collect(Collectors.summarizingDouble(Double::valueOf));
        System.out.println(intSummary.toString() + "\n" + longSummary.toString() + "\n" + doubleSummary.toString());


    }


}
