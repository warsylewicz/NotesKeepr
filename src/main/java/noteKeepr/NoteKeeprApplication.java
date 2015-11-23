package noteKeepr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "noteKeepr.repositories")
public class NoteKeeprApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(NoteKeeprApplication.class, args);
	}

	public static boolean isAdmin()
	{

		return false;
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {

		return (container -> {
			ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error_pages/401.html");
			ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error_pages/404.html");
			ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error_pages/500.html");

			container.addErrorPages(error401Page, error404Page, error500Page);
		});
	}


}



