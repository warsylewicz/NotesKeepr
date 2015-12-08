package noteKeepr.repositories;

import noteKeepr.entities.Role;
import noteKeepr.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  RoleRepository extends JpaRepository<Role, Long>
{
    Role findByRoleType(RoleType roleType);
}
