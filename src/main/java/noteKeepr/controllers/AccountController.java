package noteKeepr.controllers;

import noteKeepr.entities.Account;
import noteKeepr.models.AccountDto;
import noteKeepr.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Accounts")
public class AccountController
{

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/Updates", method = RequestMethod.PUT)
    public
    @ResponseBody
    String saveUser(@RequestBody String response)
    {
        System.out.println();


        return "Success";
    }

    @RequestMapping(value = "/GetUserList", method = RequestMethod.GET)
    public List<AccountDto> getUserSelectList() {

        return accountService.getUserSelectList();
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Account> update(@PathVariable("id") Long id, @RequestBody AccountDto accountDto)
	{
		accountService.update(id, accountDto);
		return null;
	}
}
