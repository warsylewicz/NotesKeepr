package noteKeepr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter
{
	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		registry.addViewController("/").setViewName("welcome");
		registry.addViewController("/Main").setViewName("main");
		registry.addViewController("/Notes").setViewName("main");
		registry.addViewController("/UserDetails").setViewName("main");
		registry.addViewController("/Admin").setViewName("main");
//		registry.addViewController("/Login").setViewName("welcome");
		registry.addViewController("/Register").setViewName("register");
	}
}
