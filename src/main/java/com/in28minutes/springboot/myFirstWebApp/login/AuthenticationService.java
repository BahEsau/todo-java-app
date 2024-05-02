package com.in28minutes.springboot.myFirstWebApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username, String password) {
		
		boolean isValideUsername = username.equalsIgnoreCase("Bah Esau");
		boolean isValidePassword = password.equalsIgnoreCase("dummy");
		
		return isValideUsername && isValidePassword;
	}
}
