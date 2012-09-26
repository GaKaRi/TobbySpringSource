package springbook.interfaces.factory.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnMaker {

	public abstract Connection makeConnection() 
			throws ClassNotFoundException, SQLException;
	
}
