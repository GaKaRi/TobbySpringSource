package dao.factory;

import java.sql.Connection;
import java.sql.SQLException;

import springbook.user.domain.User;

public class UserDao {
	private ConnectionMaker connectionMaker;
	
	public UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	public void add() throws ClassNotFoundException, SQLException {
		Connection c = this.connectionMaker.makeConnection();
	}
	
	public User get() {
		
		return null;
	}
}
