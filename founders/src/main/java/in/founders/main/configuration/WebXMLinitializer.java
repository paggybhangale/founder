package in.founders.main.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import in.founders.main.securityconfiguration.SecurityConfiguration;

/*Created By Parag Bhangale
 * Email:paragbhangale@hotmail.com
 * 
 * 05:08PM 24-5-2018
 * */

public class WebXMLinitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {SecurityConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {WebmvcInitializer.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"*.html","*.profile"};
	}

}
