package noteKeepr.services;

import java.util.List;
import java.util.stream.Collectors;
import noteKeepr.entities.Account;
import noteKeepr.entities.Role;
import noteKeepr.enums.RoleType;
import noteKeepr.models.AccountDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

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
}
