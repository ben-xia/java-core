package com.ben.java.core.netio.io.serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamTest01{
	public static void main(String[] args) throws Exception{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("User.DBF"));
		 Object obj = ois.readObject();
		 System.out.println("---------------" + obj);


//Exception in thread "main" java.io.InvalidClassException: User; 
		 // local class incompatible: 
		 // stream classdesc serialVersionUID = -7020619477594468968, 
		 // local class serialVersionUID = 5211548487022640024
	}
};