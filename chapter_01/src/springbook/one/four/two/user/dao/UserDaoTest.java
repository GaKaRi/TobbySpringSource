package springbook.one.four.two.user.dao;

import java.sql.SQLException;

import springbook.user.domain.User;

public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDao dao = new UserDaoFactory().userDao();

		User user = new User();
		user.setId("whiteship");
		user.setName("raks");
		user.setPassword("notmarried");

		dao.add(user);
			
		System.out.println("User ID : " + user.getId());
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
			
		System.out.println("User ID2 : " + user2.getId());
	}
}
