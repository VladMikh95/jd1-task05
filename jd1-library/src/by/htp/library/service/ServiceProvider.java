package by.htp.library.service;

import by.htp.library.service.impl.AdminServiceImpl;
import by.htp.library.service.impl.UserServiceImpl;

public class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();
	
	private UserService userService = new UserServiceImpl();
	private AdminService adminService = new AdminServiceImpl();
	
	public static ServiceProvider getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}
	
	public AdminService getAdminService() {
		return adminService;
	}
	

}
