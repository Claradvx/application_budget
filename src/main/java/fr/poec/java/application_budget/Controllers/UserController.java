package fr.poec.java.application_budget.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.poec.java.application_budget.Entities.User;
import fr.poec.java.application_budget.Services.UserServiceImpl;

@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	
	@GetMapping (value="user{id}", produces="application/json")
	public User getUserById (@PathVariable int id) {
		return (User) userService.findById(id);
	}
	
//	@PostMapping (value="signin", produces="application/json", consumes="application/json")
//	public User load  (@RequestBody String username, @RequestBody String pwd) {
//		Authentication auth = new Authentication(username, pwd);
//		User user = authenticationService.authenticate(username, pwd);
//		return user;
//	}

	@PostMapping (value="signin", produces="application/json", consumes="application/json")
	public User signIn(@RequestParam String username, @RequestParam String password) {
		Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		System.out.println("controller auth : " + auth);
		SecurityContextHolder.getContext().setAuthentication(auth);
		return new User(username, password);
	}
	
	
	
	
	
}
