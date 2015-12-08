package noteKeepr.services;

import noteKeepr.entities.Account;
import noteKeepr.entities.Role;
import noteKeepr.enums.RoleType;
import noteKeepr.exceptions.SecurityException;
import noteKeepr.models.AccountDto;
import noteKeepr.models.RegisterDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AccountService extends BaseService
{
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

        Set<RoleType> roles = account.getRoles().stream().map(Role::getRoleType).collect(Collectors.toSet());

        accountDto.setRoles(roles);

        return accountDto;
    }

	public List<AccountDto> findAll()
	{
		List<Account> entities = accountRepository.findAll();
		List<AccountDto> models = new ArrayList<>();

		entities.stream().forEach(entity -> {
			AccountDto accountDto = new AccountDto();
			accountDto.setId(entity.getId());
			accountDto.setFirstName(entity.getFirstName());
			accountDto.setLastName(entity.getLastName());
			accountDto.setUsername(entity.getUserName());
			accountDto.setEmail(entity.getEmail());
			Set<RoleType> roles = entity.getRoles().stream().map(Role::getRoleType).collect(Collectors.toSet());
			accountDto.setRoles(roles);

			models.add(accountDto);
		});

		return models;
	}

    public List<AccountDto> getUserSelectList()
    {
        User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Account currentUser = accountRepository.findByUserName(user.getUsername());

        List<Account> entities = accountRepository.findAll();
        List<AccountDto> models = new ArrayList<>();

        entities.stream().filter(entity -> !Objects.equals(currentUser.getId(), entity.getId())).forEach(entity -> {
            AccountDto accountDto = new AccountDto();
            accountDto.setId(entity.getId());
            accountDto.setFirstName(entity.getFirstName());
            accountDto.setLastName(entity.getLastName());
            models.add(accountDto);
        });

        return models;
    }

    public void update(Long id, AccountDto model)
    {
		boolean logout = false;
        User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Account currentUser = accountRepository.findByUserName(user.getUsername());

		boolean isAdmin = false;

		for (Role role : currentUser.getRoles())
		{
			if (role.getRoleType() == RoleType.ADMIN)
			{
				isAdmin = true;
			}
		}

		if (!isAdmin)
		{
			if (!Objects.equals(currentUser.getId(), id) )
			{
				throw new SecurityException();
			}
		}

		Account entity = accountRepository.findOne(id);

		Set<Role> roles = model.getRoles().stream().map(roleType -> roleRepository.findByRoleType(roleType)).collect(Collectors.toSet());

		entity.setRoles(roles);

		entity.setEmail(model.getEmail());
		entity.setFirstName(model.getFirstName());
		entity.setLastName(model.getLastName());

        if (!Objects.equals(entity.getUserName(), model.getUsername()))
        {
            if (accountRepository.findByUserName(model.getUsername())== null)
            {
				entity.setUserName(model.getUsername());
				logout = true;
            }
        }

		if (model.getPassword() != null && !model.getPassword().isEmpty() )
		{
			entity.setPassword(model.getPassword());
		}

        accountRepository.saveAndFlush(entity);

		if (logout)
		{
			SecurityContextHolder.getContext().setAuthentication(null);
		}
    }

    public boolean isValid(RegisterDto registerDto)
    {
        if (accountRepository.findByUserName(registerDto.getUsername()) != null)
        {
            return false;
        }

        Account account = new Account();

        account.setFirstName(registerDto.getFirstName());
        account.setLastName(registerDto.getLastName());
        account.setUserName(registerDto.getUsername());
        account.setEmail(registerDto.getEmail());
        account.setPassword(registerDto.getPassword());

        Set<Role> roles = new HashSet<>();

        roles.add(roleRepository.findByRoleType(RoleType.USER));

        account.setRoles(roles);
        account.setNotes(new HashSet<>());

        accountRepository.save(account);

        return true;
    }


	public void create(AccountDto model)
	{
		Account entity = new Account();
		entity.setUserName(model.getUsername());
		entity.setEmail(model.getEmail());
		entity.setFirstName(model.getFirstName());
		entity.setLastName(model.getLastName());
		entity.setPassword("password");

		Set<Role> roles = new HashSet<>();
		roles.add(roleRepository.findByRoleType(RoleType.USER));
		entity.setRoles(roles);
		entity.setNotes(new HashSet<>());

		accountRepository.save(entity);
	}

	public void delete(Long id)
	{
		accountRepository.delete(id);
	}
}
