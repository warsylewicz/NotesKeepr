package noteKeepr.controllers;

import noteKeepr.entities.Note;
import noteKeepr.repositories.AccountRepository;
import noteKeepr.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Note")
public class NoteController
{

	@Autowired
	private NoteRepository noteRepository;

	@Autowired
	private AccountRepository accountRepositry;

	@RequestMapping(value = "/{id}")
	public List<Note> getAllAccountNotes(@PathVariable("id") Long id)
	{


		return accountRepositry.findOne((long) 1).getNotes();
	}
}
