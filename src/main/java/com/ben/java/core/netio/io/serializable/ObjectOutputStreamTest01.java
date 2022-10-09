package com.ben.java.core.netio.io.serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamTest01{
	public static void main(String[] args) throws Exception{
		User u = new User("zhangsan",10);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/User.bat"));
		 oos.writeObject(u);

		 oos.flush();
		 oos.close();

	}

};