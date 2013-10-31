package springbook.ioc.constructor.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

public class UserDao {
	private ConnectionMaker connectionMaker;
	
	public UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}

	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection c = this.connectionMaker.makeConnection();

		PreparedStatement ps = c.prepareStatement(
			"insert into users(alias, name, password) values(?, ?, ?)");
		ps.setString(1, user.getAlias());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());

		ps.executeUpdate();

		ps.close();
		c.close();
	}

	public User get(int id) throws ClassNotFoundException, SQLException {
		Connection c = this.connectionMaker.makeConnection();
		PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setAlias(rs.getString("alias"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));

		rs.close();
		ps.close();
		c.close();

		return user;
	}

	

}
