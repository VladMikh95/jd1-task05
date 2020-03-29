package by.htp.library.dao;

import by.htp.library.bean.Book;

public interface AdminDao {
	boolean add(Book newBook) throws  DaoException ;
	boolean edit(int idBook, Book book)  throws  DaoException ;

}
