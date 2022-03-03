package fr.poec.java.application_budget.Tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import fr.poec.java.application_budget.Services.UserServiceImpl;

public class AppAuthProvider extends DaoAuthenticationProvider{
	
	@Autowired
	UserServiceImpl userDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
		String username = auth.getName();
		String password = auth.getCredentials().toString();
		UserDetails user = userDetailsService.loadUserByUsername(username);
	
		//user contient un password cryptÃ© - on doit crypter le password saisi par l'utilisateur cÃ´tÃ© front
		//pour pouvoir comparer les 2 passwords
		
		if(user == null || !user.getPassword().equals(PasswordTool.CryptPassword(password))) {
			throw new BadCredentialsException("Username/Password does not match");
		}
		
		return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
	}

	//Si la premiÃ¨re ne renvoie pas d'exception, donc le user existe et est utilisÃ© par la mÃ©thode support pour l'authentification
	
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
