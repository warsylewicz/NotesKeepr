package noteKeepr.repositories;

import noteKeepr.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;


@PreAuthorize("hasRole('USER')")
public interface NoteRepository extends JpaRepository<Note, Long>
{
}
