package fr.poec.java.application_budget.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.poec.java.application_budget.Repositories.Interfaces.UserRepository;
import fr.poec.java.application_budget.Services.Interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
}
