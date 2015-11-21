package noteKeepr.controllers;

import noteKeepr.entities.Note;
import noteKeepr.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Note")
public class NoteController
{

	@Autowired
	private NoteRepository noteRepository;

	@RequestMapping(value = "/{id}")
	public Note getAllAccountNotes(@PathVariable("id") Long id)
	{
		return noteRepository.findOne(id);
	}
}
