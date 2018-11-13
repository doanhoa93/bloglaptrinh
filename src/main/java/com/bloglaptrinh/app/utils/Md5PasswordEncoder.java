package com.bloglaptrinh.app.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Md5PasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return DigestUtils.md5Hex(rawPassword.toString());
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		String md5Hex = DigestUtils.md5Hex(rawPassword.toString());
		return md5Hex.equals(encodedPassword);
	}

}
