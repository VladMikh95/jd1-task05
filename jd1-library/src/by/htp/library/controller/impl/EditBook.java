package by.htp.library.controller.impl;

import by.htp.library.bean.Book;
import by.htp.library.controller.Command;
import by.htp.library.service.AdminService;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceProvider;

public class EditBook implements Command{

	@Override
	public String execute(String request) {
		String[] strings = request.split("' ");
    	int id = Integer.parseInt(strings[0].substring(strings[0].indexOf("=") + 1));
    	String author = strings[1].substring(strings[1].indexOf("=") + 1);
    	String title = strings[2].substring(strings[2].indexOf("=") + 1);
    	String status = strings[3].substring(strings[3].indexOf("=") + 1);
    	int count = Integer.parseInt(strings[4].substring(strings[4].indexOf("=") + 1));
    	Book book = new Book(id, author, title, status, count);
   	
    	String response = null;
    	
    	ServiceProvider provider = ServiceProvider.getInstance();
		AdminService adminService = provider.getAdminService();
		
		try {
			adminService.edit(id, book);
			response = "The book changed";
		} catch (ServiceException e) {
			response = "Incorrect data";
		}
		
		return response;
	}

}
