package springbook.one.three.three.user.dao;

import java.sql.SQLException;

import springbook.user.domain.User;

/**
 * 관계설정 책임을 갖는 클래스.
 * ConnectionMaker의 특정 구현 클래스 사이의 관계를 설정해준다.
 * UserDao가 어떤 ConnectionMaker 구현 클래스를 사용할지를 결정한다.
 */
public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ConnectionMaker connectionMaker = new DConnectionMaker();
		UserDao dao = new UserDao(connectionMaker);

		User user = new User();
		user.setId("whiteship");
		user.setName("raks");
		user.setPassword("notmarried");

		dao.add(user);
			
		System.out.println("User ID : " + user.getId());
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
			
		System.out.println("User2 ID : " + user2.getId());
	}
}
