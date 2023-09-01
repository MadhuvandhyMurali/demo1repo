package com.service;

import java.util.List;

import com.exception.LoginException;
import com.model.User;

public interface LoginService {
	public abstract String createUserService(User user) throws LoginException;

	public abstract User searchByUserIdService(int id) throws LoginException;

	public abstract List<User> getAllUserService();

	public abstract User readUserByUserNameAndPasswordService(String userName, String password) throws LoginException;

	public abstract User updateUserService(User user) throws LoginException;

	public abstract int deleteUserByUserIDService(int userId) throws LoginException;

}
