package by.htp.library.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.dao.AdminDao;
import by.htp.library.dao.DaoException;

public class FileAdminDao implements AdminDao{

	@Override
	public boolean add(Book newBook) throws DaoException {
		FileWriter writer = null;
		try {
			int id = numberOfLastLine(new FileReader("resources\\books.txt")) + 1;
			newBook.setId(id);
			writer = new FileWriter("resources\\books.txt", true);
			writer.write(newBook.toString());
			writer.append('\n');
			return true;
			
		} catch (IOException e) {
			throw new DaoException(e);
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch(IOException e) {
				throw new DaoException(e);
			}
		}
	}

	@Override
	public boolean edit(int idBook, Book book) throws DaoException {
		FileWriter writer = null;
		
		try {
			boolean result = false;
			List<Book> books = getBooksFromFile();
			writer = new FileWriter("resources\\books.txt");
            for (Book b : books) {
            	if (idBook == b.getId()) {
            		b = book;
            		b.setId(idBook);
            		result = true;
            	}
            	writer.write(b.toString());
            	writer.append('\n');
            }
			return result;
			
		} catch (IOException e) {
			throw new DaoException(e);
		} finally {
			try {
				if(writer != null) {
					writer.close();
				}
			}  catch (IOException e) {
				throw new DaoException(e);
			}
			
		}
	}
	
	private int numberOfLastLine(FileReader fr) throws DaoException {
		try {
			int result = 0;
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
            	result++;
                line = reader.readLine();
            }
			return result;
			
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}
	
	private List<Book> getBooksFromFile() throws DaoException {
		List<Book> books = new ArrayList<Book>();
		BufferedReader reader = null;
		
		try {
            reader = new BufferedReader(new FileReader("resources\\books.txt"));
            String line = reader.readLine();
            while (line != null) {
            	String[] strings = line.split("' ");
            	int id = Integer.parseInt(strings[0].substring(strings[0].indexOf("=") + 1));
            	String author = strings[1].substring(strings[1].indexOf("=") + 1);
            	String title = strings[2].substring(strings[2].indexOf("=") + 1);
            	String status = strings[3].substring(strings[3].indexOf("=") + 1);
            	int count = Integer.parseInt(strings[4].substring(strings[4].indexOf("=") + 1));
            	books.add(new Book(id, author, title, status, count));
                line = reader.readLine();
            }
            return books;
		} catch (IOException e) {
			throw new DaoException(e);
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				
			} catch(IOException e){
				throw new DaoException(e);
			}
		}
	}

}
