package com.ben.java.core.netio.io.serializable;

import java.io.Serializable;

public class User extends Person implements Serializable{

	//不让系统自动生成,自己显示写一个序列化版本号
	static final long serialVersionUID = 702061L;

	//如果不想让该属性参加序列化,需要使用transicent关键字
	transient String name;


	public User() {
	};


	public User(String name,int age) {
		super(age);
		this.name = name;
	}
	
	
	public String toString(){
		return "User[" + name +"]";
	};

};