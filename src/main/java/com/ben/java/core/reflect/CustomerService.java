package com.ben.java.core.reflect;

public class CustomerService {
	//登录
	public boolean login(String name,String password) {
		if ("admin".equals(name) && "123456".equals(password)) {
			return true;
		}
		return false;
	}
	
	//退出
	public void logout() {
		System.out.println("退出登录!!!");
	}

}
