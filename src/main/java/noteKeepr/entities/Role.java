package noteKeepr.entities;

import noteKeepr.enums.RoleType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Role implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private RoleType roleType;

    public Role() {}

    public Role(RoleType roleType) {
        this.roleType = roleType;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public RoleType getRoleType()
    {
        return roleType;
    }

    public void setRoleType(RoleType roleType)
    {
        this.roleType = roleType;
    }
}
