package noteKeepr.repositories;

import noteKeepr.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long>
{
    @Override
    List<Account> findAll();

    List<Account> findByLastName(@Param("name") String name);

	Account findByUserName(String userName);

}
