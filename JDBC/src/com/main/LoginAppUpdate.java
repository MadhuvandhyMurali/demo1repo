package com.main;

import java.util.List;
import java.util.Scanner;

import com.dao.LoginDao;
import com.dao.LoginDaoImpl;
import com.exception.LoginException;
import com.model.User;
import com.service.LoginService;
import com.service.LoginServiceImpl;

public class LoginAppUpdate {
	public static void main(String[] args) {
		/*
		 * 
		 * System.out.println("Enter user Id to search"); int id = scanner.nextInt();
		 * LoginService loginService = new LoginServiceImpl(); try { User userService =
		 * loginService.searchByUserIdService(id); if (userService != null) {
		 * System.out.println("user id : " + userService.getUserId());
		 * System.out.println("user name : " + userService.getPassword()); } } catch
		 * (LoginException e) { System.err.println(e.getMessage()); }
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Username ");
		String name = scanner.next();
		System.out.println("Enter the password ");
		String pass = scanner.next();
		User user = new User();
		user.setUserName(name);
		user.setPassword(pass);
		User update = null;
		LoginService loginService = new LoginServiceImpl();
		try {
			update = loginService.updateUserService(user);
			System.out.println("User ID : " + update.getUserId());
			System.out.println("User name : " + update.getUserName());
			System.out.println("Password : " + update.getPassword());

		} catch (LoginException e) {
			System.err.println(e.getMessage());
		}

		
	}

}
