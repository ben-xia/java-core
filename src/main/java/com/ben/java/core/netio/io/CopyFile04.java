package com.ben.java.core.netio.io;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 运用线程池,使用多个线程复制文件(优化)
 *
 * @author ben xia
 * @date 2018年7月21日
 */
public class CopyFile04 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        try {

            ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
//			ExecutorService fixedThreadPool = Executors.newCachedThreadPool();
            fixedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    FileInputStream fis = null;
                    FileOutputStream fos = null;
                    BufferedInputStream bis = null;
                    BufferedOutputStream bos = null;

                    try {
                        fis = new FileInputStream("F:\\download\\cn_windows_10_enterprise_ltsc_2019_x64_dvd_9c09ff24.iso");
                        fos = new FileOutputStream("D:\\cn_windows_10_enterprise_ltsc_2019_x64_dvd_9c09ff24.iso");
                        bis = new BufferedInputStream(fis);
                        bos = new BufferedOutputStream(fos);
                    } catch (FileNotFoundException e) {

                        e.printStackTrace();
                    }

                    byte[] b = new byte[1024 * 1024 * 50];
                    int len = 0;

                    try {
                        while ((len = bis.read(b)) != -1) {
                            try {
                                bos.write(b, 0, len);
                            } catch (IOException e) {

                                e.printStackTrace();
                            }
                        }
                    } catch (IOException e) {

                        e.printStackTrace();
                    }

                }
            });

            fixedThreadPool.shutdown();
        } finally {
            System.out.println("copy总耗时:\t" + (System.currentTimeMillis() - start));
        }
    }
}