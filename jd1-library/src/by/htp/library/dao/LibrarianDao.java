package by.htp.library.dao;


public interface LibrarianDao {
	boolean givePaperBook(int idLibrarian, int idUser, int idBook) throws  DaoException ;
	boolean returnBook(int isUser, int idBook) throws  DaoException ;
}
