package com.gem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnUtil {
	private static ConnUtil instance;
	
	{
		try {
			Class.forName("org.postgresql.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private final String DWARF_URL = "jdbc:postgresql://projects.cidcg5bmrsjg.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=dwarf";
	private final String USERNAME = "kevin";
	private final String PASSWORD = "tiger315";
	
	
	
	private ConnUtil() {
		super();
	}
	
	public static ConnUtil getInstance() {
		if(instance == null) {
			instance = new ConnUtil();
		} 
		return instance;
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(DWARF_URL, USERNAME, PASSWORD);
	}
	
	
	
	
}
