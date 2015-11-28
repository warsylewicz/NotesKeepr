package noteKeepr.services;

import noteKeepr.repositories.AccountRepository;
import noteKeepr.repositories.NoteRepository;
import noteKeepr.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService
{
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    NoteRepository noteRepository;

    @Autowired
    RoleRepository roleRepository;
}
