package in.founders.main.configuration;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import in.founders.main.securityconfiguration.SecurityConfiguration;

/*Created By Parag Bhangale
 * Email:paragbhangale@hotmail.com
 * 
 * 05:08PM 24-5-2018
 * */


@Configuration
@EnableWebMvc
@ComponentScan("in.founders.main")
@Import({SecurityConfiguration.class})
public class WebmvcInitializer extends WebMvcConfigurerAdapter
{

	/*Auther-Parag Bhangale
	 * 
	 * Internal View Resolver is used for the resolve the view
	 * 
	 * Equivalent XML code :-
	 * <bean id="viewResolver"
    	      class="org.springframework.web.servlet.view.InternalResourceViewResolver" >
              <property name="prefix">
                  <value>/WEB-INF/views/</value>
               </property>
              <property name="suffix">
                 <value>.jsp</value>
              </property>
        </bean>
	 * */
	@Bean
	public InternalResourceViewResolver getViewResolver()
	{
		InternalResourceViewResolver viewresolver=new InternalResourceViewResolver();
		viewresolver
					.setPrefix("/WEB-INF/views/");
		viewresolver
					.setSuffix(".jsp");
		return viewresolver;
		
	}
	
	
	
	/*Auther-Parag Bhangale*/
	/*
	 * 
	 *This method is use for the handling and accessing the external resources 
	 *in the spring like .js,.css,images etc
	 * 
	 * */
	public void resourceHandler(ResourceHandlerRegistry resourceHandlerRegistry)
	{
		resourceHandlerRegistry
								.addResourceHandler("/resources/**")
								.addResourceLocations("/resources/");
	}
	
	
	


	/*Auther-Parag Bhangale*/
	/*
	 * 
	 *This method is use for the handling and accessing the messages.properties file 
	 *which is in the src/test/rsources
	 *
	 *
	 *messages.properties->
	 *		page.header = Test page
			page.greetings = Hi everyone!
	 *
	 * after tha we can use this using Spring tag liabrary=
	 * 
	 * <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
	 *		...
	 *		<h1><spring:message code="page.header" /> </h1>
	 *		<p><spring:message code="page.greetings" /> </p>
	 * 
	 * 
	 * 
	 * */
	public MessageSource messageSource()
	{
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		messageSource
					.setBasenames("messages");
		messageSource
					.setDefaultEncoding("UTF-8");
		
		return messageSource;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
