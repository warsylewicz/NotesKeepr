package noteKeepr.repositories;

import noteKeepr.entities.Account;
import noteKeepr.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long>
{
    @Override
    List<Account> findAll();

    Account findByLastName(@Param("name") String name);

	Account findByUserName(String userName);

    Set<Account> findByNotes(Note note);

}
