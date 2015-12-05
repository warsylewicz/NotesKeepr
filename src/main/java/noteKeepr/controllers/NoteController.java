package noteKeepr.controllers;

import noteKeepr.models.NoteDto;
import noteKeepr.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Notes")
public class NoteController
{

	@Autowired
	NoteService noteService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<NoteDto> getAllAccountNotes(@PathVariable("id") Long id)
	{
        return noteService.getAccountNotes(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<NoteDto> update(@PathVariable("id") Long id, @RequestBody NoteDto noteDto)
	{
		noteService.update(noteDto);
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id)
	{
		noteService.delete(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public void create(@PathVariable("id") Long id)
	{
		noteService.create(id);
	}

}
