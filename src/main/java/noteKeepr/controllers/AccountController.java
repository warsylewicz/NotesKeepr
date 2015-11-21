package noteKeepr.controllers;

import noteKeepr.entities.Account;
import noteKeepr.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = "/Test", method = RequestMethod.GET)
    public List<Account> test()
    {
        return accountRepository.findByLastName("Lynn");
    }
}
