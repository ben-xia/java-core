package com.ben.java.core.netio.io;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

/**
 * ByteArrayOutputStream中也有一个内部缓冲区，当数据写入是缓冲区会自动增长[内存溢出]，内部有一个计数器来记录缓冲区的字节数。
 * @author ben xia
 * @date 2019年7月03日
 */
public class ByteArrayOutputStreamTest01 {
    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("G:\\开发测试环境部署文档.txt");
            // ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            byte[] bytes = new byte[1024 * 50];
            int len = 0;

            while ((len = fis.read(bytes)) != -1) {
                bos.write(bytes, 0, bytes.length);
            }

            bos.flush();
            System.out.println(bos.toString("gbk"));
//            System.out.println(new String(bos.toByteArray(), "gbk"));
            System.out.println(Base64.getEncoder().encodeToString(bos.toByteArray()));

            bos.close();
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
