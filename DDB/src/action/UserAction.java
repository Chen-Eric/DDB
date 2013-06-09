
package action;

import domain.User;

/**
 * @author Chen
 * @version 1.0
 */
public class UserAction extends BaseAction {

	/**
	 * @serial auto
	 */
	private static final long serialVersionUID = -8534550171421612227L;

	private String username;
	private String password;
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Login method
	 * @return String success
	 * @return String error if username and/or password is incorrect.
	 */
	public String login() {

		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		
		if (userService.findUserByUsername(username)) {
			if (userService.findUserByUsernameAndPassword(username, password)) {
				
				User loginUser = userService.findUser(username, password);
				
				this.session.put("loginUserID", loginUser.getId());
				this.session.put("loginUserName", loginUser.getUsername());
				
				return SUCCESS;
			}else {
				return ERROR;
			}
		} else {
			return ERROR;
		}
	}
	
	/**
	 * register method
	 * @return String success
	 * @return String error if username is used.
	 */
	public String register(){
		
		System.out.println("newUsername: " + username);
		System.out.println("newPassword: " + password);
		
		if (userService.findUserByUsername(username)) {
			//not configured yet.
			userService.addUser(username, password, role);
			
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
}
