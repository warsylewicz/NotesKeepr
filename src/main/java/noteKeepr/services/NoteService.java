package noteKeepr.services;

import noteKeepr.entities.Account;
import noteKeepr.entities.Note;
import noteKeepr.models.NoteDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class NoteService extends BaseService
{

	public void create(Long id)
	{
		Account account = accountRepository.findOne(id);
		Note note = new Note();
		note.setDateModified(new Date());
		note.setDateCreated(new Date());
		note.setTitle("New Note...");
		note.setContent("");
		note.setOwnerId(id);

		Set<Account> collaborators = new HashSet<>();
		collaborators.add(account);

		note.setCollaborators(collaborators);

		noteRepository.save(note);
		account.getNotes().add(note);
		accountRepository.saveAndFlush(account);
	}

	public List<NoteDto> getAccountNotes(Long id)
	{
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Account account = accountRepository.findByUserName(user.getUsername());
		if (!Objects.equals(account.getId(), id))
		{
			throw new SecurityException();
		}

		List<NoteDto> result = new ArrayList<>();
		Set<Note> entities = accountRepository.findOne(id).getNotes();

		for (Note note : entities)
		{
			NoteDto noteDto = new NoteDto();
			noteDto.setId(note.getId());
			noteDto.setTitle(note.getTitle());
			noteDto.setContent(note.getContent());
			noteDto.setDateCreated(note.getDateCreated());
			noteDto.setDateModified(note.getDateModified());
			noteDto.setOwner(note.getOwnerId());

			Set<Long> collaboratorIds = new HashSet<>();
			Set<Account> collaborators = note.getCollaborators();

			collaboratorIds.addAll(collaborators.stream().map(Account::getId).collect(Collectors.toList()));
			noteDto.setCollaborators(collaboratorIds);
			result.add(noteDto);
		}

		result.stream().sorted((n1, n2) -> n1.getDateModified().compareTo(n2.getDateModified()));

		return result;
	}

	public void update(NoteDto model)
	{
		List<Long> newCollaboratorIds = model.getCollaborators().stream().collect(Collectors.toList());
		List<Account> newCollaborators = newCollaboratorIds.stream().map(id -> accountRepository.findOne(id)).collect(Collectors.toList());
		Note entity = noteRepository.findOne(model.getId());
		Set<Account> accounts = accountRepository.findByNotes(entity);

		for (Account user : accounts)
		{
			Set<Note> notes = new HashSet<>();

			for (Note note : user.getNotes())
			{
				if (Objects.equals(note.getId(), entity.getId()))
				{
					notes.add(note);
				}
			}

			for (Note note : notes)
			{
				user.getNotes().remove(note);
			}
			accountRepository.saveAndFlush(user);
		}

		for (Account collaborator : newCollaborators)
		{
			entity.getCollaborators().add(collaborator);
		}

		entity.setContent(model.getContent());
		entity.setTitle(model.getTitle());
		entity.getCollaborators().clear();
		entity.setDateModified(new Date());

		noteRepository.saveAndFlush(entity);

		for (Account user : newCollaborators)
		{
			user.getNotes().add(entity);
			accountRepository.saveAndFlush(user);
		}
	}

	public void delete(Long id)
	{
		noteRepository.delete(id);
	}

}
