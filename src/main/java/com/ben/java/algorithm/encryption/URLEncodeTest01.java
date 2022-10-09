package com.ben.java.algorithm.encryption;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * urleocode只是为了url中一些非ascii字符，可以正确无误的被传输
 *
 */
public class URLEncodeTest01 {
    public static void main(String[] args) {
        try {
            String encode = URLEncoder.encode("中国", "utf-8");
            String decode = URLDecoder.decode(encode, "utf-8");
            String encode1 = URLEncoder.encode("中国", "GBK");
            System.out.println("encode1=="+ encode1);
            System.out.println(encode);
            System.out.println(decode);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }
}
