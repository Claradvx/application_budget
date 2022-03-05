package fr.poec.java.application_budget.Services.Interfaces;

import fr.poec.java.application_budget.Entities.User;

public interface UserService {
	
	public User findById(int id);
	
	public User getUserByUsername(String username);
	
	public User saveUser(User userUpdated);
	
	public User updateUser(User userUpdated);
	
	public User validateUser (User user, String password);

}
