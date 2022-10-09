package com.ben.java.core.netio.io;

import java.io.*;

/**
 * 文件复制
 * 
 * @author ben xia
 * @date 2018年7月21日
 *
 */
public class CopyFile02 {

	public static void main(String[] args) {

		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {

			fr = new FileReader("F:\\test.txt");
			br = new BufferedReader(fr);
			fw = new FileWriter("D:\\test.txt",true);
			bw = new BufferedWriter(fw);

			String temp = null;
			while ((temp=br.readLine())!=null) {
				bw.write(temp);
				bw.newLine();
			}
			
			bw.flush();
			bw.close();
			br.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {

			// closeStream(fis, fos, bos);

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
