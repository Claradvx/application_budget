package fr.poec.java.application_budget.Services;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.poec.java.application_budget.Entities.User;
import fr.poec.java.application_budget.Repositories.UserRepository;
import fr.poec.java.application_budget.Services.Interfaces.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	public User findById(int id) {
		User user = userRepo.findById(id);
		return user;
	}
	
	public User getUserByUsername(String username) {
		System.out.println("username find by username" + username);
		User user = userRepo.findByUsername(username);
		System.out.println("user find by username" + user);
		return user;
	}
	
	public User validateUser (User user, String password) {
		System.out.println("user password" + user.getPassword());
		System.out.println("input password" + password);
		System.out.println(user.getPassword() == password);
		if (user.getPassword() == password) {
			System.out.println("if coucouuuuuuuuuuuuuuuuuuuuuuuu");
			return user;
		}
		return user;
	}
	
	public User saveUser(User userUpdated) {
		userRepo.save(userUpdated);
		return userUpdated;
	}
	
	public User updateUser(User userUpdated) {
		User existingUser = userRepo.getUserById(userUpdated.getId());
		if (userUpdated.getName() != null) {
			existingUser.setName(userUpdated.getName());
		}
		if (userUpdated.getFirstname() != null) {
			existingUser.setFirstname(userUpdated.getFirstname());
		}
		if (userUpdated.getUsername() != null) {
			existingUser.setUsername(userUpdated.getUsername());
		}
		if (userUpdated.getPassword() != null) {
			existingUser.setPassword(userUpdated.getPassword());
		}
		if (userUpdated.getAge() != 0) {
			existingUser.setAge(userUpdated.getAge());
		}
		return userRepo.save(existingUser);
	}

}
