package noteKeepr.services;

import noteKeepr.entities.Account;
import noteKeepr.entities.Role;
import noteKeepr.enums.RoleType;
import noteKeepr.exceptions.SecurityException;
import noteKeepr.models.AccountDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

        List<RoleType> roles = account.getRoles().stream().map(Role::getRoleType).collect(Collectors.toList());

        accountDto.setRoles(roles);

        return accountDto;
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

        if (!Objects.equals(currentUser.getId(), id))
        {
            throw new SecurityException();
        }

        currentUser.setEmail(model.getEmail());
        currentUser.setFirstName(model.getFirstName());
        currentUser.setLastName(model.getLastName());

        if (!Objects.equals(currentUser.getUserName(), model.getUsername()))
        {
            if (accountRepository.findByUserName(model.getUsername())== null)
            {
                currentUser.setUserName(model.getUsername());
				logout = true;

            }
        }

		if (model.getPassword() != null && !model.getPassword().isEmpty() )
		{
			currentUser.setPassword(model.getPassword());
		}

        accountRepository.saveAndFlush(currentUser);

		if (logout)
		{
			SecurityContextHolder.getContext().setAuthentication(null);
		}
    }
}
