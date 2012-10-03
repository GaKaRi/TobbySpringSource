package springbook.one.six.four.user.dao;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.domain.User;

public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);

		User user = new User();
		user.setId("whiteship");
		user.setName("raks");
		user.setPassword("married");

		dao.add(user);
			
		System.out.println(user.getId());
		
		User user2 = dao.get(user.getId());
		System.out.println("User ID : " + user2.getName());
		System.out.println(user2.getPassword());
			
		System.out.println("User ID 2: " + user2.getId());
	}
}
