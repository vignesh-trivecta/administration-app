package com.email.adminstrationapp.utility;

public class RandomPasswordGenerator {

	public String generateRandomPassword(int length) {
		if (length < 4) {
			throw new IllegalArgumentException("Password length must be at least 4 characters");
		}
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
}
