package noteKeepr.controllers;

import noteKeepr.entities.Account;
import noteKeepr.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account test()
    {
        Account account = accountRepository.findByLastName("Lynn");


        return account;
    }
}
