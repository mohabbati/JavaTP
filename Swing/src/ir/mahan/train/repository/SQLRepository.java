package ir.mahan.train.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Properties;

public class SQLRepository implements IRepository {

	Connection connection;
	
	private int port;
	private String user;
	private String pass;
	private Properties properties; 
	
	public void connect() throws Exception {

		if (connection != null) {
			return;
		}
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			throw new Exception("Driver not found.");
		}
		
		String connectionURL = "jdbc:sqlserver://swsql.mahanair.aero;user=sa;password=123;database=C005_S01_N";
		connection = DriverManager.getConnection(connectionURL);
		System.out.println("Connected");
	}
	
	public void disconnect() throws Exception {
		
	}
	
	@Override
	public boolean Save(List<Object> objects) {

		String SQLcheckCommand = "select count(*) from dbo.Person where ID = ?";
		
		//PreparedStatement checkstm = connection.
		
		return false;
		
	}

	@Override
	public String Retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

}
