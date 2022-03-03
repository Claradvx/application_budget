package fr.poec.java.application_budget.Tools;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import fr.poec.java.application_budget.Services.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserServiceImpl userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf()
		.disable() //blocage des requÃªtes qui proviennent d'un poste non authentifiÃ©
		.authorizeRequests()
		.antMatchers("/signin").permitAll()
	//	.and()
	//	.exceptionHandling() //dÃ©clencher une exception
	//	.authenticationEntryPoint(new Http403ForbiddenEntryPoint()) //ressource inexistante
		.and()
		.authenticationProvider(getProvider())
//		.formLogin()
//		.loginProcessingUrl("/signin")
//		.successHandler(new AuthenticationSuccessLoginHandler())
//		.failureHandler(new SimpleUrlAuthenticationFailureHandler())
//		.and()
//		.logout()
//		.logoutUrl("/signout")
//		.logoutSuccessHandler(new AuthenticationSuccessLogoutHandler())
//		.invalidateHttpSession(true)
//		.and()
//		.authorizeRequests()
//		.antMatchers("/signout").permitAll()
//		// Liste des urls avec connexion
//		.antMatchers("/employes").authenticated()
//		.anyRequest().permitAll()
//		.and()
		.httpBasic();
		
	}

	private class AuthenticationSuccessLoginHandler extends SimpleUrlAuthenticationSuccessHandler{

		@Override
		public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
				Authentication authentication) throws IOException, ServletException {
			
			response.setStatus(HttpServletResponse.SC_OK);
		}
	}
		private class AuthenticationSuccessLogoutHandler extends SimpleUrlLogoutSuccessHandler{

			@Override
			public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {
				response.setStatus(HttpServletResponse.SC_OK);
			}

	}

	@Bean
	public AuthenticationProvider getProvider() {
		AppAuthProvider provider = new AppAuthProvider();
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
