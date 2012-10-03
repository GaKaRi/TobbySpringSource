package springbook.one.three.three.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {

	public abstract Connection makeConnection() throws ClassNotFoundException,
			SQLException;

}