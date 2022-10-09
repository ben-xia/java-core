package com.ben.java.core.reflect;

public class User {
	// Field
	private String id;
	public Integer age;
	protected String addr;
	Boolean sex;

	public User(String id, Integer age, String addr, Boolean sex) {
		super();
		this.id = id;
		this.age = age;
		this.addr = addr;
		this.sex = sex;
	}

	public User() {
		super();

	}

	@Override
	public String toString() {
		return "User [id=" + id + ", age=" + age + ", addr=" + addr + ", sex=" + sex + "]";
	}

}
