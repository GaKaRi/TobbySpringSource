package springbook.interfaces.factory.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnMaker implements ConnMaker{
	
	private static final String PASSWD = "123qwe";
	private static final String USER_ID = "spring";
	private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/springbook?characterEncoding=UTF-8";


	@Override
	public Connection makeConnection() throws ClassNotFoundException,
			SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(MYSQL_URL, USER_ID, PASSWD);
		
		return c;
	}
}
