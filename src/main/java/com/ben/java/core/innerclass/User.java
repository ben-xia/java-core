package com.ben.java.core.innerclass;

/**
 * 成员内部类
 */
public class User {

	private String name;
	private int age;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	class edit {
		public void editName(String _name, int _age) {
			User.this.name = _name;
			User.this.setAge(_age);
		}
	}
	
	public void createInnerClass(){
		edit edit = this.new edit();
		edit.editName("张三", 19);
	}
	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

	//可以通过内部类在非外部类中修改外部类的私有成员;
	public static void main(String[] args) {
		User user = new User();
		user.createInnerClass();
		System.out.println(user);

		edit edit = new User().new edit();
	}

}
