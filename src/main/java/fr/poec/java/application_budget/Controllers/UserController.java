package fr.poec.java.application_budget.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.poec.java.application_budget.Entities.User;
import fr.poec.java.application_budget.Services.UserServiceImpl;

@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@GetMapping (value="user{id}", produces="application/json")
	public User getUserById (@PathVariable int id) {
		return (User) userService.findById(id);
	}

}
