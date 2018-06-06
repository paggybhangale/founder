/** author -parag bhangale 6 Jun 2018
	bhangaleparags@gmail.com
 * 
 */
package in.founders.main.Handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author ${parag bhangale} parag bhangale
 *bhangaleparags@gmail.com
 *6 Jun 2018  in.founders.main.Handlers founders TODO
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.AuthenticationSuccessHandler#onAuthenticationSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpSession session=httpServletRequest.getSession();
		
		User Authuser=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		session.setAttribute("username", Authuser.getUsername());
		System.out.println(Authuser.getUsername());
		httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		httpServletResponse.sendRedirect("IndexPage.html");
		session.setAttribute("messageafterlogin", "Redirected By login");
		session.setAttribute("logoutbutton", "<a href='logoutfromsession.html'>LogOut</a>");
		
	}

}
