package by.htp.library.controller.impl;

import by.htp.library.controller.Command;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceProvider;
import by.htp.library.service.UserService;

public class ChangeUserStatus implements Command{

	@Override
	public String execute(String request) {   	
    	String[] strings = request.split("' ");
    	int id = Integer.parseInt(strings[0].substring(strings[0].indexOf("=") + 1));
    	String status = strings[1].substring(strings[1].indexOf("=") + 1);

    	
    	String response = null;
    	
    	ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();
		
		try {
			userService.changeUserStatus(id, status);
			response = "Status changed";
		} catch (ServiceException e) {
			response = "Incorrect data";
		}
		
		return response;
	}

}
