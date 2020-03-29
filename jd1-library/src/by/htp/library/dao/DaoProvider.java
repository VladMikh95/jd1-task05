package by.htp.library.dao;

import by.htp.library.dao.impl.FileAdminDao;
import by.htp.library.dao.impl.FileUserDao;

public class DaoProvider {
	private static final DaoProvider instance = new DaoProvider();
	
	private DaoProvider() {}
	
	
	private UserDao userDao = new FileUserDao();
	private AdminDao adminDao = new FileAdminDao();
	
	public static DaoProvider getInstance() {
		return instance;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}
	
	

}
