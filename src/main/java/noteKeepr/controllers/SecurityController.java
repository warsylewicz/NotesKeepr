package noteKeepr.controllers;

import noteKeepr.entities.Account;
import noteKeepr.entities.Role;
import noteKeepr.enums.RoleType;
import noteKeepr.models.AccountDto;
import noteKeepr.repositories.AccountRepository;
import noteKeepr.services.AccountService;
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
	private AccountService accountService;

	@RequestMapping(value = "/CurrentUser")
	public AccountDto getCurrentUser()
	{
		return accountService.getCurrentUser();
	}
}
