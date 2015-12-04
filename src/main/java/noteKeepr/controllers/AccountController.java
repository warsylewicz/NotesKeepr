package noteKeepr.controllers;

import noteKeepr.entities.Account;
import noteKeepr.models.AccountDto;
import noteKeepr.models.NoteDto;
import noteKeepr.repositories.AccountRepository;
import noteKeepr.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/Accounts")
public class AccountController
{

    @Autowired
    private AccountService accountService;

//    @RequestMapping(value = "/Update/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Void> save(@RequestBody NoteDto noteDto, UriComponentsBuilder ucBuilder)
//    {
//        System.out.println();
//
//
//        return "Success";
//    }

    @RequestMapping(value = "/Updates", method = RequestMethod.PUT)
    public
    @ResponseBody
    String saveUser(@RequestBody String response)
    {
        System.out.println();


        return "Success";
    }
}
