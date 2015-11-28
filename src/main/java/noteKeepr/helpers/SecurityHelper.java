package noteKeepr.helpers;


import noteKeepr.entities.Account;
import noteKeepr.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class SecurityHelper
{
    @Autowired
    AccountRepository accountRepository;

    static AccountRepository staticAccountRepository;

    @Autowired
    public void setStaticAccountRepository(AccountRepository accountRepository) {
        SecurityHelper.staticAccountRepository = accountRepository;
    }

    public static Long getCurrentUserId()
    {
        User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Account account = staticAccountRepository.findByUserName(user.getUsername());

        return account.getId();
    }
}
