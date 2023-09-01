package com.main;

import java.util.Scanner;

import com.exception.LoginException;
import com.model.User;
import com.service.LoginService;
import com.service.LoginServiceImpl;

public class LoginAppReadNameAndPassword {
	public static void main(String[] args)  {
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter the UserName : ");
	    String name = scanner.next();
	    System.out.println("Enter the password : ");
	    String password  = scanner.next();
	  
	    LoginService loginService = new LoginServiceImpl();
	  
	    try {
			User userReUser = loginService.readUserByUserNameAndPasswordService(name, password);
			if(userReUser != null ) {
				System.out.println("User id " +userReUser.getUserId());
				System.out.println("User name "+ userReUser.getUserId());
			}
			
		} catch (LoginException e) {
           System.err.println(e.getMessage());
		}
	    
	}
	

}
