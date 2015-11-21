package noteKeepr.config;


import noteKeepr.entities.Account;
import noteKeepr.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;

@Controller
@EnableJpaRepositories(basePackages = "noteKeepr.repositories")
public class SecurityConfiguration extends GlobalAuthenticationConfigurerAdapter
{
	@Autowired
	AccountRepository accountRepository;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailsService());
	}

	@Bean
	UserDetailsService userDetailsService()
	{
		return username -> {
			Account account = accountRepository.findByUserName(username);

			if (account != null)
			{
				if (account.getRoles().size() > 0)
				{
					return new User(account.getUserName(), account.getPassword(), AuthorityUtils.createAuthorityList("ADMIN"));
				} else
				{
					return new User(account.getUserName(), account.getPassword(), AuthorityUtils.createAuthorityList("USER"));
				}
			} else
			{
				throw new UsernameNotFoundException("could not find the account '"
						+ username + "'");
			}
		};
	}
}
