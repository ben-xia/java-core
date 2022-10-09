package com.ben.java.algorithm.encryption;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

/**
 * 图片转base64放在页面直接展示
 *
 * <img src="data:image/jpg;base64,${String}" class="images" border="5px"/>
 */
public class Base64ImageTest02 {
    public static void main(String[] args) {
        Base64.Encoder encoder = Base64.getEncoder();
        FileInputStream fis = null;
        byte[] bytes = null;
        try {
            fis = new FileInputStream("G:\\工作安排\\微信图片_20190319084746.jpg");  //image的路径
            bytes = new byte[fis.available()];
            fis.read(bytes);

            String imageStr = encoder.encodeToString(bytes);
            System.out.println("imageStr==" + imageStr);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fis) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
