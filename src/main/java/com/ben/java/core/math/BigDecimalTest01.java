package com.ben.java.core.math;

import java.math.BigDecimal;

/**
 * BigDecimal舍入模式
 * https://my.oschina.net/sunchp/blog/670909
 *
 *  BigDecimal.ROUND_UP;        远离0的舍入    <-0->
 *  BigDecimal.ROUND_DOWN;      靠近0的舍入    ->0<-
 *  BigDecimal.ROUND_CEILING;    向上舍入      ->0->
 *  BigDecimal.ROUND_FLOOR;       向下舍入     <-0<-
 *  BigDecimal.ROUND_HALF_UP;     向最接近的数字方向舍入，如果与两个相邻数字的距离相等，则向上舍入。
 *  BigDecimal.ROUND_HALF_DOWN;   向最接近的数字方向舍入，如果与两个相邻数字的距离相等，则向下舍入。
 *  BigDecimal.ROUND_HALF_EVEN;
 *
 */
public class BigDecimalTest01 {
    public static void main(String[] args) {

        BigDecimal bd1 = new BigDecimal(30);
        BigDecimal bd2 = new BigDecimal("-1.0");
        BigDecimal bd3 = new BigDecimal(7);
        BigDecimal bd4 = BigDecimal.ZERO;
        BigDecimal bd5 = BigDecimal.ONE;
        BigDecimal bd6 = new BigDecimal("3.1415");
        double d = 3.1415;
        float f = 3.1415f; //小数默认是double
        BigDecimal bd7 = new BigDecimal(Double.toString(d));   //
        BigDecimal bd8 = new BigDecimal(Float.toString(f));   //


//        System.out.println(bd1.divide(bd3,2,BigDecimal.ROUND_UP));
//        System.out.println(bd1.divide(bd3,2,BigDecimal.ROUND_DOWN));
//        System.out.println(bd1.divide(bd3,2,BigDecimal.ROUND_CEILING));
//        System.out.println(bd1.divide(bd3,2,BigDecimal.ROUND_FLOOR));
//        System.out.println(bd1.divide(bd3,2,BigDecimal.ROUND_HALF_UP));
//        System.out.println(bd1.divide(bd3,2,BigDecimal.ROUND_HALF_DOWN));
//
//        System.out.println(new BigDecimal(5.5).setScale(0,BigDecimal.ROUND_HALF_DOWN));
//        System.out.println(new BigDecimal(5.55).setScale(1,BigDecimal.ROUND_HALF_DOWN));

        System.out.println(BigDecimal.ZERO.compareTo(BigDecimal.ONE));

        double v = bd6.doubleValue();
        int i = bd6.intValue();
        float v1 = bd6.floatValue();
        long l = bd6.longValue();

        System.out.println("v==" + v + " | i==" + i + " | v1==" + v1 + " | l==" + l);

        System.out.println(bd2.setScale(0,BigDecimal.ROUND_CEILING));

    }


}
