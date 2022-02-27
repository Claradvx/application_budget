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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		return user;
	}

}
