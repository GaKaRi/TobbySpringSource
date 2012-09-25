package springbook.interfaces.factory.user.dao;

public class UserDaoFactory {

	public UserDao userDao() {
		UserDao dao = new UserDao(connMaker());
		return dao;
	}
	
	private ConnMaker connMaker() {
		ConnMaker connectionMaker = new DConnMaker();
		return connectionMaker;
	}
	
}
