package com.ben.java.core.annotation;

@DBTable(name = "member")
public class Member {
	@SQLString(30) String firstName;
	@SQLString(30)  String lastName;
	@SQLInteger Integer age;
	@SQLString(value=30,constraints=@Constraints(primarykey = true)) String handle;
	static int memberCount;
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Integer getAge() {
		return age;
	}
	public String getHandle() {
		return handle;
	}
	public static int getMemberCount() {
		return memberCount;
	}
	
	@Override
	public String toString() {
		return handle ;
	}
	
}
