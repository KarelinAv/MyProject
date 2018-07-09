package com.karelin.validation;

public class RegValidation {

	public static boolean testLogin(String login) {
		return login.matches("^.{5,15}$");
	}
	
	public static boolean testPassword(String password, String repeat_password) {
		return password.matches("^(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$") && password.equals(repeat_password);
	}
	
	public static boolean testEmail(String email) {
		return email.matches("^[-._a-z0-9]+@(?:[a-z0-9][-a-z0-9]+\\.)+[a-z]{2,6}$");
	}

}
