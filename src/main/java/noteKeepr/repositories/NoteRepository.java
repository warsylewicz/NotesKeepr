package noteKeepr.repositories;

import noteKeepr.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>
{
}
