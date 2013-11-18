package dao.factory;

public class UserDaoFactory {
	public UserDao userDao() {
		UserDao dao = new UserDao(getConnectionMaker());
		
		return dao;
	}
	
	public ConnectionMaker getConnectionMaker() {
		ConnectionMaker connectionMaker = new DConnectionMaker();
		return connectionMaker;
	}
}
