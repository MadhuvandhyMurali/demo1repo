package com.service;

import java.sql.Connection;
import java.util.List;

import com.dao.LoginDao;
import com.dao.LoginDaoImpl;
import com.exception.LoginException;
import com.model.User;

public class LoginServiceImpl implements LoginService {

	@Override
	public String createUserService(User user)throws LoginException {
		// Validation
		String daoString = " ";
		Connection connection = LoginDaoImpl.getConnection();
		if(user.getPassword().length() >= 5) {
			LoginDao loginDao = new LoginDaoImpl();
			daoString = loginDao.createUser(user);
		}else {
			throw new LoginException("Password > 5");
		}
		return daoString;
	}

	@Override
	public User readUserByUserNameAndPasswordService(String userName, String password) throws LoginException {
		User daoRead=null;
		Connection connection = LoginDaoImpl.getConnection();
		if(userName.length() >= 2 && password.length() >= 5) {
			LoginDao loginDao= new LoginDaoImpl();
			daoRead =loginDao.readUserByUserNameAndPassword(userName, password) ;
		}else {
			throw new LoginException("User Name > 2 and Password > 5");
			
		}
		return daoRead;
	}

	@Override
	public User updateUserService(User user) throws LoginException {
		Connection connection = LoginDaoImpl.getConnection();
		User daoUpdate = null;
		if(user.getPassword().length() >= 5) {
			LoginDao loginDao = new LoginDaoImpl();
			daoUpdate = loginDao.updateUser(user);
		}else {
			throw new LoginException(" Password must be greater than 5");
			
		}
		return daoUpdate;
	}

	@Override
	public int deleteUserByUserIDService(int userId) throws LoginException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User searchByUserIdService(int id) throws LoginException {
	    //int length = String.valueOf(id).length();
		User userDao = null;
	    if(id > 9 && id < 100) {  // 2 digit number
	    	LoginDao loginDao = new LoginDaoImpl();
	    	userDao = loginDao.searchByUserId(id);
	    }else {
	    	throw new LoginException("Please check user id " );
	    }
		return userDao;
	}

	@Override
	public List<User> getAllUserService() {
	     List<User> userList ;
		LoginDao loginDao = new LoginDaoImpl();
	     userList =loginDao.getAllUser();
		return userList;
	}

}
