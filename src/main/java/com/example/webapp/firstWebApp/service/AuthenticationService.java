package com.example.webapp.firstWebApp.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public Boolean authenticate(String name, String password) {
		// TODO Auto-generated method stub
		boolean username = name.equalsIgnoreCase("admin");
		boolean Password = password.equalsIgnoreCase("admin");
		
		return username && Password;
	}
}
