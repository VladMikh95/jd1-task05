package by.htp.library.controller.impl;

import by.htp.library.bean.User;
import by.htp.library.controller.Command;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceProvider;
import by.htp.library.service.UserService;

public class RegistrationCommand implements Command {

	@Override
	public String execute(String request) {
		String response = "";

		UserService service = ServiceProvider.getInstance().getUserService();
		// params[1]
		User user = new User();
		try {
			service.registration(user);
			response = "reg......";
		} catch (ServiceException e) {
			// log
			response = "error";
		}
		

		return response;
	}

}
