package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.exception.LoginException;
import com.model.User;


public class LoginDaoImpl implements LoginDao {
	
  
	public static Connection getConnection() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
		try {
			String driverName = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/stg";
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, "root", "Reset123");
			System.out.println(connection != null ? "connection established" : "connection failed");
			
		

		} catch (ClassNotFoundException cnfe) {
			System.out.println("There is no respective jars : " + cnfe.getMessage());
		} catch (SQLException se) {// Catching SQL Exception
			System.out.println("SQL Exception :" + se.getMessage());
		} catch (Exception e) {
			System.out.println(e);
		}

		/*
		 * finally { try { connection.close(); } catch (SQLException e) {
		 * e.printStackTrace(); } }
		 */
		return connection;
	}

	@Override
	public String createUser(User user) {
		// need DB Connection
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		String insertQuery = "INSERT INTO user (user_name,password) values(?,?)";
		try {
			preparedStatement =connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.execute();
		} catch (SQLException e) {


			e.printStackTrace();
		}
		return user.getUserName();
	}

	@Override
	public User readUserByUserNameAndPassword(String userName, String password) throws LoginException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User userRead = null;
		String read = "SELECT * FROM user WHERE user_name = ? AND password=? ";
		try {
			preparedStatement=connection.prepareStatement(read);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2,password);
		    resultSet = preparedStatement.executeQuery();
		    userRead = new User();
		    while(resultSet.next()) {
		    	userRead.setUserId(resultSet.getInt("user_id"));
		    	userRead.setUserName(resultSet.getString("user_name"));
		    	userRead.setPassword(resultSet.getString("password"));
		    	
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userRead ;
	}

	@Override
	public User updateUser(User user) throws LoginException {
       Connection connection = getConnection();
       PreparedStatement preparedStatement= null;
       ResultSet resultSet = null;
       User userUpdate = null;
       int none = 0;
       String update = " UPDATE user SET password = ? WHERE user_name= ?";
       try {
		preparedStatement=connection.prepareStatement(update);
		preparedStatement.setString(1 , user.getPassword());
		preparedStatement.setString(2, user.getUserName());
		none =preparedStatement.executeUpdate();
		if(none >0) {
			String str = "SELECT * FROM user WHERE user_name= ?";
			preparedStatement =connection.prepareStatement(str);
			preparedStatement.setString(1,user.getUserName());
			resultSet= preparedStatement.executeQuery();
			userUpdate = new User();
			while(resultSet.next()) {
				userUpdate.setUserId(resultSet.getInt("user_id"));
				userUpdate.setUserName(resultSet.getString("user_name"));
	            userUpdate.setPassword(resultSet.getString("password"));
			
			
			
		}
		
		}
	} catch (SQLException e) {
		
		System.err.println("User Name is mismatch");
	}
       
		return userUpdate;
	}

	@Override
	public int deleteUserByUserID(int userId) throws LoginException {
		
		return 0;
	}

	@Override
	public User searchByUserId(int id) throws LoginException {
        Connection connection =getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        String search = "SELECT user_id,user_name,password FROM user WHERE user_id= ?";
        try {
			preparedStatement = connection.prepareStatement(search);
			preparedStatement.setInt(1, id);
			resultSet=preparedStatement.executeQuery();
			user = new User();
			while(resultSet.next()) {
			user.setUserId(resultSet.getInt("user_id"));
			user.setUserName(resultSet.getString("user_name"));
			user.setPassword(resultSet.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getAllUser() {
		PreparedStatement preparedStatement = null;
	    Connection connection =getConnection();
	    ResultSet resultSet = null;
	    List<User> users = null;
	    String readAll = "SELECT * FROM user";
	    try {
			preparedStatement = connection.prepareStatement(readAll);
			resultSet=preparedStatement.executeQuery();
			users = new ArrayList<User>();
			User userList = new User();
			while(resultSet.next()) {
				userList.setUserName(resultSet.getString("user_name"));
				userList.setUserId(resultSet.getInt("user_id "));
				userList.setPassword(resultSet.getString("password"));
				users.add(userList);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
}
