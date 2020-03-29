package by.htp.library.service;

import by.htp.library.bean.User;

public interface UserService {
	
	boolean authorization(String login, String password)  throws ServiceException;
	boolean registration(User user)  throws ServiceException;
	boolean changeUserStatus(int idUser, String newStatus) throws ServiceException;

}
