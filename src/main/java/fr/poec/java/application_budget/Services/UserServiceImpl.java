package fr.poec.java.application_budget.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.poec.java.application_budget.Entities.User;
import fr.poec.java.application_budget.Repositories.UserRepository;

import fr.poec.java.application_budget.Tools.PasswordTool;

@Service
public class UserServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	
	public void InsertUser(User user) {
		user.setPassword(PasswordTool.CryptPassword(user.getPassword()));
		userRepo.save(user);
	}
	
	public UserDetails findById(int id) {
		User user = userRepo.findById(id);
		return user;
	}
	
	public UserDetails getUserByUsername(String username) {
		System.out.println("username find by username" + username);
		UserDetails user = userRepo.findByUsername(username);
		System.out.println("user find by username" + user);
		return (User) user;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		System.out.println("username service : " + username);
		System.out.println("user service : " + user);
		if (user == null) {
			throw new UsernameNotFoundException("erreur pas de user");
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
