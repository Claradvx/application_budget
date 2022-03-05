package fr.poec.java.application_budget.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.poec.java.application_budget.Entities.User;
import fr.poec.java.application_budget.Services.UserServiceImpl;

@RestController
@RequestMapping("/")
public class ConnexionController {
	
	@Autowired
	UserServiceImpl userService;

	@PostMapping (value="signin", produces="application/json", consumes="application/json")
	public User signIn(@RequestBody User user) {
		System.out.println("user: " + user);
		User userLogged = userService.validateUser(userService.getUserByUsername(user.getUsername()), user.getPassword());
	    return userLogged;
	}
	
    @GetMapping(value = "signout", produces="application/text")
    public String signOut() {
        return "logout";
    }
    
    
}
