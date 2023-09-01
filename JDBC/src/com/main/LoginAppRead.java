package com.main;


import java.util.Scanner;

import com.dao.LoginDao;
import com.dao.LoginDaoImpl;
import com.exception.LoginException;
import com.model.User;
import com.service.LoginService;
import com.service.LoginServiceImpl;

public class LoginAppRead {
	public static void main(String[] args) {
		//LoginDaoImpl.getConnection();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the username : ");
		String iName = scanner.next();
		
		System.out.println("Enter password : ");
		String pwd = scanner.next();
		
		User user = new User();
		user.setUserName(iName);
		user.setPassword(pwd);
		
		//LoginDao logindao = new LoginDaoImpl();
		LoginService loginService = new LoginServiceImpl();
		
		
		String strDao = null;
		try {
			strDao = loginService.createUserService(user);
			if(strDao != null) {
				System.out.println(strDao + "has been successfully created");
			}else {
				System.out.println("something went worng");
			}
			
		} catch (LoginException e) {
		 System.err.println(e.getMessage());
		}
		
	}

}
