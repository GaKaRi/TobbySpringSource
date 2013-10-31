package dao.factory;

public class UserDaoTest {

	public static void main(String[] args) {
		try {
			UserDao userDao = new UserDaoFactory().userDao();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
