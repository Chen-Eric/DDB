/**
 * 
 */
package service.impl;

import dao.impl.UserDAO;
import domain.User;
import service.IUserService;

/**
 * @author Chen
 * 
 */
public class UserService implements IUserService {

	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public boolean findUserByUsername(String username) {
		if (userDAO.findByProperty("username", username).isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean findUserByUsernameAndPassword(String username,
			String password) {
		if (userDAO.findByProperty("username", username).isEmpty()
				|| userDAO.findByProperty("password", password).isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public User findUser(String username, String password) {
		return (User) userDAO.findByProperty("username", username).get(0);
	}

	@Override
	public void addUser(String username, String password, String role) {
		// TODO Auto-generated method stub

	}


}
