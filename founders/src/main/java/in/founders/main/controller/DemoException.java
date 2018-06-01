/** author -parag bhangale 1 Jun 2018
	bhangaleparags@gmail.com
 * 
 */
package in.founders.main.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ${parag bhangale} parag bhangale
 *bhangaleparags@gmail.com
 *1 Jun 2018  in.founders.main.controller founders TODO
 */
@RestController
public class DemoException {

	
	@RequestMapping("nullpointerexcetion.profile")
	public ModelAndView getView() throws NullPointerException
	{
		String Null="EXCEPTION";
		
		
		ModelAndView andView=new ModelAndView("generic");
		if(Null =="EXCEPTION")
		{
			
			throw new NullPointerException("null pointer excetion handler");
		}
		
		return andView;
	}
	
	
	
	@ExceptionHandler(value=NullPointerException.class)
	public String handleNullPointerException(Exception e)
	{
		System.out.println("null pointer exception");
		return "nullpointerexcetionjsp";
	}
	
	
}
