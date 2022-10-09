package com.ben.java.core.netio.io;

import org.checkerframework.common.reflection.qual.GetClass;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件复制
 * 
 * @author ben xia
 * @date 2018年7月21日
 *
 */
public class CopyFile01 {

	public static void main(String[] args) {

		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			fis = new FileInputStream("F:\\download\\LosingKayden(2012)DVDRip\\Losing.Kayden.XXX.DVDRip.x264-Jiggly.mp4");
			fos = new FileOutputStream("D:\\Losing.Kayden.XXX.DVDRip.x264-Jiggly.mp4");
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			byte[] b = new byte[1024*1024*50];
			int len = 0;
			
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
			while ((len = bis.read(b)) != -1) {
				bos.write(b,0,len);
			}
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
			fos.flush();
			bos.flush();
			
			System.out.println("flush()完毕!!!");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {

			closeStream(fis, fos, bos);

		}

	}

	private static void closeStream(FileInputStream fis, FileOutputStream fos, BufferedOutputStream bos) {
		if (bos != null) {
			try {
				bos.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		if (fos != null) {
			try {
				fos.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		if (fos != null) {
			try {
				fos.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

}
