package com.ben.java.algorithm.encryption;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class HexTest01 {
    public static void main(String[] args) throws DecoderException {
        String name = "zhangsan";
//        String s = new String(Hex.encodeHex(name.getBytes()));
        String nameEncode = Hex.encodeHexString(name.getBytes());
//        System.out.println(s.equals(nameEncode));

        String decodeName = new String(Hex.decodeHex(nameEncode.toCharArray()));

        System.out.println("nameEncode======" + nameEncode);
        System.out.println("decodeName======" + decodeName);

    }
}
