package springbook.interfaces.factory.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

public class UserDao {

	private ConnMaker connMaker;
	
	public UserDao(ConnMaker simpleConnMaker) {
		this.connMaker = simpleConnMaker;
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection conn = this.connMaker.makeConnection();
		PreparedStatement ps = conn.prepareStatement("insert into users(alias, name, password) values(?,?,?)");
		ps.setString(1, user.getAlias());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
		
	}
	
	public User get(int id) throws ClassNotFoundException, SQLException {
		
		String query = null;
		if(id == 0) {
			query = "select * from users";
		}
		else {
			query = "select * from users where id = ?";
		}
		
		Connection conn = this.connMaker.makeConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		if(id != 0) {
			ps.setInt(1,  id);
		}
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		User user = new User();
		user.setId(rs.getString("id"));
		user.setAlias(rs.getString("alias"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		conn.close();
		
		return user;
	}
	
}
