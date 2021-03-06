package by.htp.library.controller.impl;

import by.htp.library.bean.Book;
import by.htp.library.controller.Command;
import by.htp.library.service.AdminService;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceProvider;

public class AddNewBook implements Command{

	@Override
	public String execute(String request) {
		String[] strings = request.split("' ");
    	String author = strings[0].substring(strings[0].indexOf("=") + 1);
    	String title = strings[1].substring(strings[1].indexOf("=") + 1);
    	String status = strings[2].substring(strings[2].indexOf("=") + 1);
    	int count = Integer.parseInt(strings[3].substring(strings[3].indexOf("=") + 1));
    	Book book = new Book(author, title, status, count);
   	
    	String response = null;
    	
    	ServiceProvider provider = ServiceProvider.getInstance();
		AdminService adminService = provider.getAdminService();
		
		try {
			adminService.add(book);
			response = "The book added";
		} catch (ServiceException e) {
			response = "Incorrect data";
		}
		
		return response;
	}

}
