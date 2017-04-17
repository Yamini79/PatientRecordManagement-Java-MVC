package com.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static ConnectionManager instance = null;
	
	private final String USERNAME = 	"root";
	private final String PASSWORD = 	"Yamii2127";
	private final String CONN_STRING = "jdbc:mysql://localhost:3309/patients";
	
	private Connection conn = null;
	
	private ConnectionManager(){
	}
	
	public static ConnectionManager getInstance(){
		if(instance == null){
			instance = new ConnectionManager();
		}
		return instance;
	}
	private boolean openConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 throw new RuntimeException(e);
		}
		return true;
	}
	public Connection getConnection(){
			if(conn == null){
				if(openConnection()){
						System.out.println("Connection Opened");
						return conn;
				}else{
					return null;
				}
			}
			return conn;
	}
}
