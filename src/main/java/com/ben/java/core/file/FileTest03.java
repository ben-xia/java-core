package com.ben.java.core.file;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 递归查找出指定目录下的所有的文件
 *
 * @author ben xia
 * @date 2018年7月22日
 */
public class FileTest03 {
    private static AtomicInteger atomicInteger_0 = new AtomicInteger();
    private static AtomicInteger atomicInteger_1 = new AtomicInteger();
    private static AtomicInteger atomicInteger_2 = new AtomicInteger();

    public static void main(String[] args) {

        File f = new File("G:\\wallet_biz_web");
//        File f = new File("C:\\Users\\Administrator\\Desktop\\wallet_biz_web___不能删除");
        f1(f);
        f2(f);
        f3(f);
        System.out.println("总计删除多少个文件====" + atomicInteger_0);
        System.out.println("总计修改多少个文件====" + atomicInteger_1);
        System.out.println("总计有多少个文件====" + atomicInteger_2);

    }

    /**
     * 删除不适合的文件
     * @param f
     */
    public static void f1(File f) {
        // 如果f是文件
        if (f.isFile()) {
            return; // 1.方法的结束 2.返回值
        }

        File[] listFiles = f.listFiles();

        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) { // 如果file是文件
                if (file.isFile()) {
                    String fileName = file.getName();
                    String substring = fileName.substring(0, 2);
                    if (!"1_".equals(substring)) {
                        file.delete();
                        atomicInteger_0.incrementAndGet();
                    }
                } else {//如果file是目录
                    f1(file);

                }

            }
        }


    }

    ;

    /**
     * 给文件改名
     * @param f
     */
    public static void f2(File f) {
        // 如果f是文件
        if (f.isFile()) {
            String fileName = f.getName();
            String substring = fileName.substring(0, 2);

            String absolutePath = f.getAbsolutePath();
            int i = absolutePath.lastIndexOf("\\");

            if ("1_".equals(substring)) {
                if (f.renameTo(new File(absolutePath.substring(0, i + 1) + absolutePath.substring(i + 3)))) {
                    System.out.println("修改成功");

                } else {
                    System.out.println("修改失败");
                }
                atomicInteger_1.incrementAndGet();
            }
            return; // 1.方法的结束 2.返回值
        }

        //2.如果f是目录
        File[] listFiles = f.listFiles();

        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) { // 如果file是文件
                if (file.isFile()) {
                    String fileName = file.getName();
                    String substring = fileName.substring(0, 2);

                    String absolutePath = file.getAbsolutePath();
                    int i = absolutePath.lastIndexOf("\\");

                    if ("1_".equals(substring)) {
                        if (file.renameTo(new File(absolutePath.substring(0, i + 1) + absolutePath.substring(i + 3)))) {
                            System.out.println("修改成功");

                        } else {
                            System.out.println("修改失败");
                        }
                        atomicInteger_1.incrementAndGet();
                    }

                } else {//如果file是目录
                    f2(file);

                }

            }
        }
    }

    /**
     * 统计文件的个数
     * @param f
     */
    public static void f3(File f) {
        // 如果f是文件
        if (f.isFile()) {
            atomicInteger_2.incrementAndGet();
            return; // 1.方法的结束 2.返回值
        }

        File[] listFiles = f.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) { // 如果file是文件
                    if (file.isFile()) {
                        atomicInteger_2.incrementAndGet();
                    } else {//如果file是目录
                        f3(file);

                    }

                }
            }
        }
    }

}
