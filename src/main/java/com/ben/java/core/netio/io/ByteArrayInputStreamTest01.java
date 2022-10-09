package com.ben.java.core.netio.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * https://blog.csdn.net/hbtj_1216/article/details/53129588
 * ByteArrayInputStream中:包含一个内部缓冲区，用来包含那些可能从流中读的字节数组。还有一个内部计数器来跟踪下一个将被读取的字节。
 *                        ByteArrayInputStream只能用字节数组来进行构造。
 * @author ben xia
 * @date 2019年7月04日
 */
public class ByteArrayInputStreamTest01 {
    public static void main(String[] args) throws IOException {
        String str = "吉林张斌";

        //Unicode的编码就是UTF-16，每个字符占两个字节，UTF-8每个字符占3个字节
        ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes("UTF-16"));


        int len = bais.available();                            //之所以多了两个字节，是因为String串在最后有一个不可见的'\0'字符
        System.out.println(len);

        byte[] testread = new byte[6];
        bais.read(testread);                                 //只读取6个字节

        ByteBuffer bb = ByteBuffer.allocate(testread.length);//定义一个ByteBuffer，长度为字节数组长度
        bb.put(testread);                                    //用testread初始化ByteBuffer
        bb.flip();                                           //游标归0 *****
//        bb.compact();

        Charset cs = Charset.forName("UTF-16");             //定义编码
        CharBuffer cb = cs.decode(bb);                       //将ByteBuffer转换为CharBuffer
        char[] chs = cb.array();                             //读出CharBuffer中的字节


        for (int i = 0; i < chs.length; i++)
            System.out.println(chs[i]);

        if (chs[chs.length - 1] == '\0')
            System.out.println("最后一个字符表示空");         //表示最后一个字符是'\0'
        else
            System.out.println("最后一个字符非空");
    }
}
