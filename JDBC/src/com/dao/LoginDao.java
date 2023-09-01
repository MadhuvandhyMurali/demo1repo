package com.dao;

import java.util.List;

import com.exception.LoginException;
import com.model.User;

public interface LoginDao {
	public abstract String createUser(User user);

	public abstract User searchByUserId(int id) throws LoginException;

	public abstract List<User> getAllUser();

	public abstract User readUserByUserNameAndPassword(String userName, String password) throws LoginException;

	public abstract User updateUser(User user) throws LoginException;

	public abstract int deleteUserByUserID(int userId) throws LoginException;

}
