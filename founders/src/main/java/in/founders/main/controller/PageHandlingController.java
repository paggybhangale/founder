package in.founders.main.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/*Created By Parag Bhangale
 * Email:paragbhangale@hotmail.com
 * 
 * 05:08PM 24-5-2018
 * */


@RestController
public class PageHandlingController {
	
	ModelAndView view_jsp;
	Map<String,String> modelMap;
	
	
	
	/* this method is resolve the view page of Landingpage  
	 *   ----.html mapping for every link
	 * **/
	@RequestMapping(value="/IndexPage.html",method=RequestMethod.GET)
	private ModelAndView getLandingPage_Jsp()
	{
		 modelMap=new HashMap<String ,String>();
		 view_jsp=new ModelAndView("LandingPage");
		modelMap.put("PageTitle", "Welcome To the Paggys Blog");
		view_jsp.addAllObjects(modelMap); //we are adding all the objects in this page through this map
		return view_jsp;
	}
	
	
	@RequestMapping(value="/GenericPage.html",method=RequestMethod.GET)
	private ModelAndView getGenericPage_Jsp()
	{
		view_jsp=new ModelAndView("generic");
		return view_jsp;
		
	}
	
	
	@RequestMapping(value="/ElementsPage.html",method=RequestMethod.GET)
	private ModelAndView getElementsPage_Jsp()
	{
		view_jsp=new ModelAndView("elements");
		return view_jsp;
		
	}
	
	
	
}
