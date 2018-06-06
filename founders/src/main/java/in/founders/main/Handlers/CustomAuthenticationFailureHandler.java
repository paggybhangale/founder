/** author -parag bhangale 6 Jun 2018
	bhangaleparags@gmail.com
 * 
 */
package in.founders.main.Handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * @author ${parag bhangale} parag bhangale
 *bhangaleparags@gmail.com
 *6 Jun 2018  in.founders.main.Handlers founders TODO
 */
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.AuthenticationFailureHandler#onAuthenticationFailure(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.AuthenticationException)
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		
		
		
		

	}

}
