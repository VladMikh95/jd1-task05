package by.htp.library.dao.impl;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.htp.library.bean.User;
import by.htp.library.dao.DaoException;
import by.htp.library.dao.UserDao;

public class FileUserDao implements UserDao{
	
	@Override
	public boolean authorization(String login, String password) throws DaoException {
			for (User user : getUsersFromFile()) {
				if ((login.equals(user.getLogin())) && (password.equals(user.getPassword()))) {
					return true;
				}
			}
			return false;	

	}

	@Override
	public boolean registration(User newUser) throws DaoException{
		FileWriter writer = null;
		try {
			int id = numberOfLastLine(new FileReader("resources\\users.txt")) + 1;
			newUser.setId(id);
			writer = new FileWriter("resources\\users.txt", true);
			writer.write(newUser.toString());
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
	public boolean changeUserStatus(int idUser, String newStatus) throws DaoException {
		FileWriter writer = null;
		
		try {
			boolean result = false;
			List<User> users = getUsersFromFile();
			writer = new FileWriter("resources\\users.txt");
            for (User user : users) {
            	if (idUser == user.getId()) {
            		user.setStatus(newStatus);
            		result = true;
            	}
            	writer.write(user.toString());
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
	
	private List<User> getUsersFromFile() throws DaoException {
		List<User> users = new ArrayList<User>();
		BufferedReader reader = null;
		
		try {
            reader = new BufferedReader(new FileReader("resources\\users.txt"));
            String line = reader.readLine();
            while (line != null) {
            	String[] strings = line.split("' ");
            	int id = Integer.parseInt(strings[0].substring(strings[0].indexOf("=") + 1));
            	String login = strings[1].substring(strings[1].indexOf("=") + 1);
            	String password = strings[2].substring(strings[2].indexOf("=") + 1);
            	String name = strings[3].substring(strings[3].indexOf("=") + 1);
            	String role = strings[4].substring(strings[4].indexOf("=") + 1);
            	String status = strings[5].substring(strings[5].indexOf("=") + 1);
            	users.add(new User(id, login, password, name, role, status));
                line = reader.readLine();
            }
            return users;
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
