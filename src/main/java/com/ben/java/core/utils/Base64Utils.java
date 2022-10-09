package com.ben.java.core.utils;

import java.io.*;
import java.util.Base64;

/**
 * @author ben-xia
 * @desc
 * @date 2019/5/26
 */
public class Base64Utils {

    /**
     * base64编码字符串转换为图片
     *
     * @param imgStr base64编码字符串
     * @param path   图片路径
     * @return
     */
    public static boolean base64StrToImage(String imgStr, String path) {
        if (imgStr == null)
            return false;
//        BASE64Decoder decoder = new BASE64Decoder();
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            // 解密
//          byte[] b = decoder.decodeBuffer(imgStr);
            byte[] b = decoder.decode(imgStr);


            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            //文件夹不存在则自动创建
            File tempFile = new File(path);
            if (!tempFile.getParentFile().exists()) {
                tempFile.getParentFile().mkdirs();
            }
            OutputStream out = new FileOutputStream(tempFile);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 图片转base64字符串
     *
     * @param imgFile 图片路径
     * @return
     */
    public static String imageToBase64Str(String imgFile) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
//        BASE64Encoder encoder = new BASE64Encoder();
//        return encoder.encode(data);

        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(data);

    }

    public static void main(String[] args) {
        String base64Str = imageToBase64Str("F:/tools/16.API/images/main.png");
        System.out.println(base64Str);

        boolean b = base64StrToImage(base64Str, "F:/tools/16.API/images/main01.png");
        System.out.println(b);
    }
}
