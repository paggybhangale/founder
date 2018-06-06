/** author -parag bhangale 6 Jun 2018
	bhangaleparags@gmail.com
 * 
 */
package in.founders.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ${parag bhangale} parag bhangale
 *bhangaleparags@gmail.com
 *6 Jun 2018  in.founders.main.controller founders TODO
 */


@RestController
public class LoginController {

	ModelAndView loginview;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView getLoginPage()
	{
		loginview=new ModelAndView("/CustomLoginPage/CustomloginPage");
		loginview
				.addObject("Welcome","Login Here!!");
		
		return loginview;
	}
	
	
	@RequestMapping(value="/loginfailure.html")
	public ModelAndView getLoginFailure()
	{
		loginview=new ModelAndView("failure404");
		return loginview;
	}
	
	
	
	@RequestMapping(value="/logoutfromsession.html",method=RequestMethod.GET)
	public ModelAndView logoutHandler(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)
	{
		loginview=new ModelAndView("LandingPage");
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null)
		{
			SecurityContextLogoutHandler contextLogoutHandler=new SecurityContextLogoutHandler();
			
			if(contextLogoutHandler.isInvalidateHttpSession())  
			{
				
				loginview
						.addObject("logout_successfully", "you are not logged in ever!!");
				
			}
			else {
				
				
				contextLogoutHandler
								.logout(httpServletRequest, httpServletResponse, authentication);
			}
		}
		
		loginview=new ModelAndView("/CustomLoginPage/CustomloginPage");
		loginview.addObject("logout_successfully", "you are successfully logout");
		
	
		return loginview;
	}
	
	
	
}
