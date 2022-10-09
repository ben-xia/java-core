package com.ben.java.core.netio.io;

import java.io.*;

public class BufferStreamTest01 {

	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("F:\\tools\\16.API\\网络协议\\06b355394f525c54f200d8a1af63ddea.jpg")));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("F:\\abc.jpg")));
		
		
		byte[] bytes = new byte[1024*10];
		int num;
		while ((num=bis.read(bytes))!=-1) {
			bos.write(bytes, 0, num);
		}
		 bos.flush();
		 bos.close();
		 bis.close();
		

	}

}
