package com.main;

import java.util.List;
import java.util.Scanner;

import com.dao.LoginDao;
import com.dao.LoginDaoImpl;
import com.exception.LoginException;
import com.model.User;
import com.service.LoginService;
import com.service.LoginServiceImpl;

public class LoginApp {
	public static void main(String[] args) {
		/*
		 * Scanner scanner = new Scanner(System.in);
		 * System.out.println("Enter user Id to search"); int id = scanner.nextInt();
		 * LoginService loginService = new LoginServiceImpl(); try { User userService =
		 * loginService.searchByUserIdService(id); if (userService != null) {
		 * System.out.println("user id : " + userService.getUserId());
		 * System.out.println("user name : " + userService.getPassword()); } } catch
		 * (LoginException e) { System.err.println(e.getMessage()); }
		 */

		LoginService loginService = new LoginServiceImpl();
		List<User> listUser = loginService.getAllUserService();
		for (User user : listUser) {
			System.out.println("User ID : " + user.getUserId());
			System.out.println("User name : " + user.getUserName());
			System.out.println("Password : " + user.getPassword());

		}
	}

}
