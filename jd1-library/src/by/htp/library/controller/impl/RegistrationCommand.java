package by.htp.library.controller.impl;

import by.htp.library.bean.User;
import by.htp.library.controller.Command;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceProvider;
import by.htp.library.service.UserService;

public class RegistrationCommand implements Command {

	@Override
	public String execute(String request) {
		String[] strings = request.split("' ");
    	String login = strings[0].substring(strings[0].indexOf("=") + 1);
    	String password = strings[1].substring(strings[1].indexOf("=") + 1);
    	String name = strings[2].substring(strings[2].indexOf("=") + 1);
    	String role = strings[3].substring(strings[3].indexOf("=") + 1);
    	User user = new User(login, password, name, role);
    	
    	String response = null;
    	
    	ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();
		
		try {
			userService.registration(user);
			response = "You are registered";
		} catch (ServiceException e) {
			response = "Incorrect data";
		}
		
		return response;
	}

}
