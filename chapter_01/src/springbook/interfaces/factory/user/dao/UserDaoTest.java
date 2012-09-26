package springbook.interfaces.factory.user.dao;

import springbook.user.domain.User;

public class UserDaoTest {

	public static void main(String[] args) {
		try {
			UserDao dao = new UserDaoFactory().userDao();
			
			User user = new User();
			user.setAlias("greateRaks");
			user.setName("choi raksuns.");
			user.setPassword("asdfasdf");
			
			dao.add(user);
			
			User user2 = dao.get(0);
			System.out.println("User Id : " + user2.getId());
			System.out.println("User Alias : " + user2.getAlias());
			System.out.println("User name : " + user2.getName());
			System.out.println("User Password : " + user2.getPassword());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
