package in.founders.main.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*Created By Parag Bhangale
 * Email:paragbhangale@hotmail.com
 * 
 * 05:08PM 24-5-2018
 * */


@Configuration
@EnableWebMvc
@ComponentScan("in.founders.main")
public class WebmvcInitializer extends WebMvcConfigurerAdapter
{

	/*Auther-Parag Bhangale
	 * 
	 * Internal View Resolver is used for the resolve the view
	 * 
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
	
}
