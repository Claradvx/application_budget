package fr.poec.java.application_budget.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.poec.java.application_budget.Dto.ParticipantDto;
import fr.poec.java.application_budget.Entities.Participant;
import fr.poec.java.application_budget.Entities.User;
import fr.poec.java.application_budget.Services.UserServiceImpl;

@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	
	@GetMapping (value="user/{id}", produces="application/json")
	public User getUserById (@PathVariable int id) {
		return (User) userService.findById(id);
	}
	
	@GetMapping (value="test/{username}", produces="application/json", consumes="application/json")
	public User getUserByUsername (@PathVariable String username) {
		System.out.println("username" + username);
		User user = (User) userService.getUserByUsername(username);
		System.out.println("user" + user);
//		if (user.getPassword() == password) {
//			return user;	
//		}
		return (User) user;
	}
	
//	@PostMapping (value="signin", produces="application/json", consumes="application/json")
//	public User load  (@RequestBody String username, @RequestBody String pwd) {
//		Authentication auth = new Authentication(username, pwd);
//		User user = authenticationService.authenticate(username, pwd);
//		return user;
//	}

//	@PostMapping (value="signin", produces="application/json", consumes="application/json")
//	public User signIn(@RequestParam String username, @RequestParam String password) {
//		Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//		System.out.println("controller auth : " + auth);
//		SecurityContextHolder.getContext().setAuthentication(auth);
//		return new User(username, password);
//	}
	
	@PutMapping(value="updateuser", consumes="application/json", produces = "application/json")
	public User updateUser(@RequestBody User user){
		userService.updateUser(user);
		return user;
	}

	@PostMapping(value="saveuser", consumes="application/json", produces = "application/json")
	public User saveUser(@RequestBody User user){
		userService.saveUser(user);
		return user;
	}
	
}
