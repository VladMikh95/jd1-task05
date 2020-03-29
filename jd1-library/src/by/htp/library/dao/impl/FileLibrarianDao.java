package by.htp.library.dao.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.dao.DaoException;
import by.htp.library.dao.LibrarianDao;

public class FileLibrarianDao implements LibrarianDao{

	@Override
	public boolean givePaperBook(int idLibrarian, int idUser, int idBook) {
		return false;
	}

	@Override
	public boolean returnBook(int isUser, int idBook) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
