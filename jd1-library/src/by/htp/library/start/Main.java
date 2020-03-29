package by.htp.library.start;

import by.htp.library.bean.*;
import by.htp.library.controller.Controller;
import by.htp.library.dao.DaoException;
import by.htp.library.dao.impl.FileAdminDao;
import by.htp.library.dao.impl.FileUserDao;
import by.htp.library.service.ServiceException;
import by.htp.library.service.impl.AdminServiceImpl;
import by.htp.library.service.impl.UserServiceImpl;

public class Main {

	public static void main(String[] args) throws DaoException, ServiceException {
		Controller controller = new Controller();
		
		/*String request, response;
		
		request = "login=aaa password=bbb name=Ivan";

		response = controller.action(request);
		
		System.out.println(response);*/
		
		UserServiceImpl fl = new UserServiceImpl();
		
		User user = new User("aab", "bbb", "ccc", "ddd");
	
		fl.registration(user);
		System.out.println(fl.authorization("aaa", "bbb"));
		System.out.println(fl.changeUserStatus(2, "blocked"));
		
		
		AdminServiceImpl fa = new AdminServiceImpl();
		Book book = new Book("Бейтс", "Изучаем Java", "paper", 50);
		fa.add(book);
		System.out.println(fa.edit(2, new Book("Эккель", "Философия Java", "paper, dig", 40)));
	}

}
