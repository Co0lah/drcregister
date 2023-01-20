package fr.doranco.tpjsf2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DorancoDataSource {

	private static DorancoDataSource instance;
	
	private DorancoDataSource() {};
	
	
	public static DorancoDataSource getInstance() {
		if (instance == null) {
			instance = new DorancoDataSource();
		}
		return instance;
	}
	public Connection getConnection() throws SQLException {
		String user =  "root";
		String password =  "";
		String url =  "jdbc:mysql://127.0.0.1:3306/jsf_database";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
}
