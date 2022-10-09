package com.ben.java.core.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ben-xia
 * @date 2019/09/15
 * @Description https://www.cnblogs.com/wang-zai/p/7802622.html
 **/
public class PatternTest01 {

    public static void main(String[] args) {
//        pattern 对象是一个正则表达式的编译表示。
        Pattern p = Pattern.compile("a*b");
//        Matcher 对象是对输入字符串进行解释和匹配操作的引擎
        Matcher m = p.matcher("aaaaab");
        boolean b = m.matches();
        System.err.println(b);

//        注意：String类也有matches()方法，如"abcd".matches(regExp)，
//        其实他们俩是等价的，String类matches()方法就是调用的Pattern.matches()方法：
//        如果只想知道该字符串是否匹配表达式，则直接使用matches()方法最简单
        boolean b1 = Pattern.matches("a*b", "aaaaab");
        System.out.println(b1);

    }
}
