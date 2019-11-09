package com.comviva.col.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Password Encryptions using MD5.
 * 
 * @author samarth.sangam
 *
 */
public class PasswordEncryption {
	private static MessageDigest md;

	private PasswordEncryption() {
	}

	public static String encrypt(String pass) {
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] passBytes = pass.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			// TODO: Test StringBuilder to StringBuffer if required
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < digested.length; i++) {
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException ex) {
			// TODO: Add Logger
			System.out.println(ex.getMessage());
		}
		return null;

	}
}