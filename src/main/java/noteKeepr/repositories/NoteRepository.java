package noteKeepr.repositories;

import noteKeepr.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long>
{
}
