package noteKeepr.controllers;

import noteKeepr.entities.Note;
import noteKeepr.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Note")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @RequestMapping(value = "/Test", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public List<Note> test()
    {
       return noteRepository.findAll();
    }
}
