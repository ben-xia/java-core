package com.ben.java.core.netio.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * PrintStram:标准的输出流,默认打印到控制台,以字节方式; PrintWriter:以字符的方式;
 * 可以改变PrintStream的输出方向,通常使用此种方式来记录日志
 * 
 * @author ben xia
 * @date 2018年7月22日
 *
 */
public class PrintStreamTest01 {

	public static void main(String[] args) {

		// System.out.println("Java是一门计算机语言!!!");

		// 标准的输出流,默认打印到控制台
		PrintStream out = System.out;
		out.println("Java是一门计算机语言!!!");

		try {
			// 改变PrintStream的输出方向,通常使用此种方式来记录日志
			System.setOut(new PrintStream(new FileOutputStream("F:\\log.log", true)));
			System.out.println("我可以创建日志文件了!!!");

			System.out.println("m1()方法执行开始时间" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
			m1();
			System.out.println("m1()方法执行结束时间" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	public static void m1() {
		System.err.println("m1()方法执行了");
		
	};
}
