package springbook.factory.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {
	private static final String PASSWD = "book";
	private static final String USER_ID = "spring";
	private static final String MYSQL_URL = "jdbc:mysql://localhost/springbook?characterEncoding=UTF-8";

	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(MYSQL_URL, USER_ID, PASSWD);
		return c;
	}
}
