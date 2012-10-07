package springbook.one.five.one.user.dao;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.domain.User;

public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);

		User user = new User();
		user.setAlias("october");
		user.setName("raks");
		user.setPassword("married");

		dao.add(user);
			
		System.out.println("User ID : " + user.getAlias());
		
		User user2 = dao.get(user.getAlias());
		System.out.println(user2.getName());
		System.out.println(user2.getAlias());
		System.out.println(user2.getPassword());
			
		System.out.println("User ID2 : " + user2.getId());
	}
}
