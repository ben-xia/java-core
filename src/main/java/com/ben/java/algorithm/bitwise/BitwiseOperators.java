package com.ben.java.algorithm.bitwise;

/**
 * @author ben-xia
 * @date 2020/03/25
 * @Description 位运算符:首先将数据看成二进制数,然后对其按位操作; [符号位: 0正1负]
 * & 按位与: 双目运算符,只有对应的两个二进位均为1时，结果位才为1 ，否则为0。负数参与运算的数以补码方式出现。
 * | 按位或 :双目运算符,只要对应的二个二进位有一个为1时，结果位就为1。负数参与运算的两个数均以补码出现。
 * ^ 按位异或:双目运算符,当两对应的二进位相异时，结果为1。负数参与运算数仍以补码出现。
 * ~取反: 单目运算符,其功能是对参与运算的数的各二进位按位求反。
 * <<左移: 双目运算符,左移n位就是乘以2的n次方。 其功能把“<<”左边的运算数的各二进位全部左移若干位，由“<<”右边的数指定移动的位数，高位丢弃，低位补0。
 * >>右移:双目运算符,右移n位就是除以2的n次方,其功能是把“>>”左边的运算数的各二进位全部右移若干位，“>>”右边的数指定移动的位数。
 * (右移对符号位的处理和左移不同:对于有符号数,在右移时,符号位将随同移动: 当为正数时,最高位补0,而为负数时,符号位为1)
 **/

public class BitwiseOperators {
    public static void main(String[] args) {
        Byte a = 10 & 2;
        Byte b = 10 | 2;
        Byte c = 10 ^ 2;
        Byte d = ~10;
        Byte e = 10 << 2;
        Byte f = 10 >> 2;
        int h=~127;


        int g = -15;
        g >>= 1;
        //源码 -> 反码 - > 补码(负数是以补码的形式存在的:  补码 = 反码+1); [有符号: 高位0:+,高位1:-]
        //(源码)   :   10000000 00000000 00000000 00000000 00000000 00000000 00000000 00001111
        //(反码)   :   11111111 11111111 11111111 11111111 11111111 11111111 11111111 11110000
        //(补码)   :   11111111 11111111 11111111 11111111 11111111 11111111 11111111 11110001
        //(补码)>>1:   11111111 11111111 11111111 11111111 11111111 11111111 11111111 11111000
        //(反码)    :  11111111 11111111 11111111 11111111 11111111 11111111 11111111 11110111
        //(源码)    :  10000000 00000000 00000000 00000000 00000000 00000000 00000000 00001000

        System.out.println("a=" + a);  //2
        System.out.println("b=" + b);  //10
        System.out.println("c=" + c);  //8
        System.out.println("d=" + d);  //
        System.out.println("e=" + e);  //40
        System.out.println("f=" + f);  //2
        System.out.println("g=" + g);  //-8
        System.out.println("h=" + h);  //-8

    }
}
