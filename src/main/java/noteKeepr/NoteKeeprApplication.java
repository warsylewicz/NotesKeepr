package noteKeepr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "noteKeepr.repositories")
public class NoteKeeprApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(NoteKeeprApplication.class, args);
	}

}

