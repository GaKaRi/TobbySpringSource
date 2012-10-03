package springbook.one.six.five.sandbox;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.finals.user.dao.DaoFactory;
import springbook.finals.user.dao.UserDao;
 
public class SingletonTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		
		System.out.println(context.getBean(UserDao.class));
		System.out.println(context.getBean(UserDao.class));
	}
} 
