package noteKeepr.controllers;

import noteKeepr.entities.Note;
import noteKeepr.models.NoteDto;
import noteKeepr.repositories.AccountRepository;
import noteKeepr.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("/Notes")
public class NoteController
{

	@Autowired
	private NoteRepository noteRepository;

	@Autowired
	private AccountRepository accountRepositry;

	@RequestMapping(value = "/All/{id}")
	public List<NoteDto> getAllAccountNotes(@PathVariable("id") Long id)
	{
		List<NoteDto> result = new ArrayList<>();
		Set <Note> entities = accountRepositry.findOne(id).getNotes();

		for(Note note : entities)
		{
			NoteDto noteDto = new NoteDto();
			noteDto.setId(note.getId());
			noteDto.setTitle(note.getTitle());
			noteDto.setContent(note.getContent());
			noteDto.setCollaborators(note.getCollaborators());
			noteDto.setDateCreated(note.getDateCreated());
			noteDto.setDateModified(note.getDateModified());
			if (Objects.equals(id, note.getOwnerId()))
			{
				noteDto.setOwner(true);
			}
			else {
				noteDto.setOwner(false);
			}
			result.add(noteDto);
		}

		result.stream().sorted((n1, n2) -> n1.getDateCreated().compareTo(n2.getDateCreated()));

		return result;
	}

	@RequestMapping(value = "/FindAll")
	public List<Note> findAll()
	{


		return noteRepository.findAll();
	}
}
