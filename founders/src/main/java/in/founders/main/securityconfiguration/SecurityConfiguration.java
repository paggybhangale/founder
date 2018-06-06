package in.founders.main.securityconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import in.founders.main.Handlers.CustomAuthenticationFailureHandler;
import in.founders.main.Handlers.CustomAuthenticationSuccessHandler;

/*Created By Parag Bhangale
 * Email:paragbhangale@hotmail.com
 * 
 * 05:08PM 24-5-2018
 * */


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder authenticationManager) throws Exception
	{
		
		authenticationManager
							.inMemoryAuthentication()
							.withUser("parag@gmail.com")
							.password("{noop}Parag@123")
							.roles("webmaster")
							.and()
							.withUser("paragadmin@gmail.com")
							.password("{noop}paragadmin@123")
							.roles("admin");
	}
	
	
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception
	{
		
		boolean clearAuthentication=true;		
		boolean invalidateHttpSession = true;
		String logoutUrl ="/logoutfromsession.html";
		
		
		
		httpSecurity
					.authorizeRequests()
							.antMatchers("/IndexPage.html")
								.access("hasRole('webmaster')")
					.anyRequest().authenticated()			
					.and()
							.csrf()
					.and()
							.formLogin()
							//.loginPage("/login")
							.usernameParameter("username")
							.passwordParameter("password")
							.loginProcessingUrl("/login")
							.successHandler(new CustomAuthenticationSuccessHandler())
							.failureHandler(new CustomAuthenticationFailureHandler())
					.and()
						.logout()
						.clearAuthentication(clearAuthentication)
						.invalidateHttpSession(invalidateHttpSession )
						.logoutUrl(logoutUrl)
					.and()
							.sessionManagement()
							.invalidSessionUrl("/login?time=1")
							.maximumSessions(5);
							
							
							
	}						
	
	
	
	
}
