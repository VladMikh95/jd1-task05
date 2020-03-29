package by.htp.library.service;

import by.htp.library.bean.Book;

public interface AdminService {
	boolean add(Book book) throws ServiceException;
	boolean edit(int idBook, Book book) throws ServiceException;
}
