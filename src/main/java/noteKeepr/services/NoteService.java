package noteKeepr.services;

import noteKeepr.entities.Note;
import noteKeepr.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    public List<Note> findAll(Long id)
    {
//        List<Note> notes = noteRepository.findAll().stream().filter(f -> f.getId() == id).collect(Collectors.toList());


        System.out.println();

        return noteRepository.findAll();
    }
}
