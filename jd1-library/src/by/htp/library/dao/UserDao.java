package by.htp.library.dao;

import by.htp.library.bean.User;

public interface UserDao {
	
	boolean authorization(String login, String password) throws  DaoException ;
	boolean registration(User newUser) throws  DaoException ;
	boolean changeUserStatus(int idUser, String newStatus) throws  DaoException ;

}
