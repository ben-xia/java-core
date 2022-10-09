package com.ben.java.core.netio.io;

import java.io.*;

/**
 * ObjectOutputStream: 将JVM中的java对象状态序列化保存到硬盘;
 * ObjectInputStream: 将硬盘中的数据"反序列化"到JVM内存;
 * 
 * @author ben xia
 * @date 2018年7月22日
 *
 */
public class ObjectOutputStreamTest01 {

	public static void main(String[] args) {

		User u1 = new User("张三", 23);
		try {
			 ObjectOutputStream oos = new ObjectOutputStream(new
			 FileOutputStream("f:/test.txt"));
			 oos.writeObject(u1);
			
			
			 oos.flush();
			 oos.close();
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("f:\\test.txt"));
			User user = (User) ois.readObject();
			System.out.println(user);

			ois.close();

		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

}

/**
 * 标识接口的作用:起到标识的作用
 * JVM如果看到该对象实现了某个标识接口,会对他特殊待遇;
 * @author ben xia
 * @date   2018年7月22日
 *
 */
class User implements Serializable {
	String name;
	int age;

	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

};