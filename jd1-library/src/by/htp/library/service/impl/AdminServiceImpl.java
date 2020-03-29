package by.htp.library.service.impl;

import by.htp.library.bean.Book;
import by.htp.library.dao.AdminDao;
import by.htp.library.dao.DaoException;
import by.htp.library.dao.DaoProvider;
import by.htp.library.service.AdminService;
import by.htp.library.service.ServiceException;

public class AdminServiceImpl implements AdminService{

	@Override
	public boolean add(Book book) throws ServiceException{
		if (book == null) {
			throw new ServiceException("Incorrect book");
		}
		
		if ((book.getAuthor() == null) || (book.getAuthor().isEmpty())) {
			throw new ServiceException("Incorrect author of book");
		}
		
		if ((book.getTitle() == null) || (book.getTitle().isEmpty())) {
			throw new ServiceException("Incorrect title of book");
		}
		
		if ((book.getStatus() == null) || (book.getStatus().isEmpty())) {
			throw new ServiceException("Incorrect status of book");
		}
		
		if (book.getCount() < 1) {
			throw new ServiceException("Number of book cannot be less than one");
		}

		boolean result = false;
		DaoProvider provider = DaoProvider.getInstance();
		AdminDao adminDao = provider.getAdminDao();
		
		try {
			result = adminDao.add(book);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		
		return result;
	}

	@Override
	public boolean edit(int idBook, Book book) throws ServiceException {
		if (book == null) {
			throw new ServiceException("Incorrect book");
		}

		boolean result = false;
		DaoProvider provider = DaoProvider.getInstance();
		AdminDao adminDao = provider.getAdminDao();
		
		try {
			result = adminDao.edit(idBook, book);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		
		return result;
	}

}
