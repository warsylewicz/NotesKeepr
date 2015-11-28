package noteKeepr.services;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import noteKeepr.entities.Account;
import noteKeepr.entities.Note;
import noteKeepr.models.NoteDto;
import noteKeepr.repositories.AccountRepository;
import noteKeepr.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class NoteService extends BaseService
{

    public List<NoteDto> getAccountNotes(Long id)
    {

        User user = ( User ) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountRepository.findByUserName(user.getUsername());
        if ( !Objects.equals(account.getId(), id) )
        {
            throw new SecurityException();
        }

        List<NoteDto> result = new ArrayList<>();
        Set<Note> entities = accountRepository.findOne(id).getNotes();

        for ( Note note : entities )
        {
            NoteDto noteDto = new NoteDto();
            noteDto.setId(note.getId());
            noteDto.setTitle(note.getTitle());
            noteDto.setContent(note.getContent());
            noteDto.setCollaborators(note.getCollaborators());
            noteDto.setDateCreated(note.getDateCreated());
            noteDto.setDateModified(note.getDateModified());
            if ( Objects.equals(id, note.getOwnerId()) )
            {
                noteDto.setOwner(true);
            }
            else
            {
                noteDto.setOwner(false);
            }
            result.add(noteDto);
        }

        result.stream().sorted((n1, n2) -> n1.getDateCreated().compareTo(n2.getDateCreated()));

        return result;
    }

    public void update(NoteDto model)
    {
        Note entity = noteRepository.findOne(model.getId());
    }
}
