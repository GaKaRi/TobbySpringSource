package springbook.user.dao.interfaces;

import java.sql.SQLException;

import springbook.user.domain.User;

public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ConnectionMaker connectionMaker = new DConnectionMaker();
		UserDao dao = new UserDao(connectionMaker);

		User user = new User();
		user.setName("raks");
		user.setPassword("notmarried");
		user.setAlias("vvv");

		dao.add(user);
			
		System.out.println("User ID : " + user.getId());
		
		User user2 = dao.get(1);
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
			
		System.out.println("User2 ID : " + user2.getId());
	}
}
