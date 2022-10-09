package com.ben.java.core.annotation;

import java.util.List;

public class PasswordUtils {
	
	@UseCase(id =47,description="密码必须包含数字")
	public boolean validatePassword(String password) {
		return password.matches("\\w*\\d\\w*");
	} 

	@UseCase(id = 48)
	public 	String encryptPassword(String password) {
		return new StringBuilder(password).reverse().toString();
	}
	@UseCase(id = 49,description="新密码不能与之前的密码相同")
	public boolean checkForPassword(List<String> prevPasswords, String password) {
		return  !prevPasswords.contains(password);
	}
	
	public boolean x(List<String> prevPasswords, String password) {
		return  !prevPasswords.contains(password);
	}
	
}
