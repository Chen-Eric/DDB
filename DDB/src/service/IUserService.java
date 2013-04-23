package service;

import domain.User;

public interface IUserService {
	
	public boolean findUserByUsername(String username);
	
	public boolean findUserByUsernameAndPassword(String username, String password);
	
	public User findUser(String username, String password);
	
	public void addUser(String username, String password, String role);
	
}
