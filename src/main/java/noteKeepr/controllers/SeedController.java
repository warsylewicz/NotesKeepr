package noteKeepr.controllers;

import noteKeepr.entities.Account;
import noteKeepr.entities.Note;
import noteKeepr.entities.Role;
import noteKeepr.enums.RoleType;
import noteKeepr.repositories.AccountRepository;
import noteKeepr.repositories.NoteRepository;
import noteKeepr.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Seed")
public class SeedController {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping("/Reload")
    public void loadSeedData()
    {
        // Clear the repositories
        accountRepository.deleteAll();
        noteRepository.deleteAll();
        roleRepository.deleteAll();

        List<Role> roles = new ArrayList<>();
        List<Note> notes = new ArrayList<>();

        // Add the user roles to the repository
        roleRepository.save(new Role(RoleType.ADMIN));
        roleRepository.save(new Role(RoleType.USER));

        // Create the admin users

        roles.add(new Role(RoleType.ADMIN));

        accountRepository.save(new Account("Admin", "Admin", "admin", "admin@gmail.com", "password", roles, notes));
        accountRepository.save(new Account("Master", "Root", "master", "master@gmail.com", "password", roles, notes));

        // Create the regular users
        roles.clear();

        roles.add(new Role(RoleType.USER));

        accountRepository.save(new Account("Fred", "Flinstone", "fred", "fred@gmail.com", "password", roles, notes));
        accountRepository.save(new Account("Wilma", "Flinstone", "wilma", "wilma@gmail.com", "password", roles, notes));
        accountRepository.save(new Account("Barney", "Rubble", "barney", "barney@gmail.com", "password", roles, notes));







    }
}
