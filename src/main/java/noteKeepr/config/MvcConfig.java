package noteKeepr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter
{
	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		registry.addViewController("/Welcome").setViewName("welcome");
		registry.addViewController("/").setViewName("welcome");
		registry.addViewController("/Main").setViewName("main");
		registry.addViewController("/Login").setViewName("login");
		registry.addViewController("/Register").setViewName("register");
	}

}
