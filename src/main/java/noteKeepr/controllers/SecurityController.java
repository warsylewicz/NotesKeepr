package noteKeepr.controllers;

import noteKeepr.entities.Account;
import noteKeepr.entities.Role;
import noteKeepr.enums.RoleType;
import noteKeepr.models.AccountDto;
import noteKeepr.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SecurityController
{
	@Autowired
	private AccountRepository accountRepository;

	@RequestMapping(value = "/CurrentUser")
	public AccountDto getCurrentUser()
	{
		User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Account account = accountRepository.findByUserName(user.getUsername());

		AccountDto accountDto = new AccountDto();
		accountDto.setId(account.getId());
		accountDto.setEmail(account.getEmail());
		accountDto.setFirstName(account.getFirstName());
		accountDto.setLastName(account.getLastName());
		accountDto.setUsername(account.getUserName());

		List<RoleType> roles = account.getRoles().stream().map(Role::getRoleType).collect(Collectors.toList());

		accountDto.setRoles(roles);

		return accountDto;


	}
}
