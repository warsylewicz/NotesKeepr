package noteKeepr.repositories;

import noteKeepr.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  RoleRepository extends JpaRepository<Role, Long>
{

}
