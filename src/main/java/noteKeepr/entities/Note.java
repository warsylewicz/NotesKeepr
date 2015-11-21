package noteKeepr.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Note implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;

    private Long ownerId;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Account> collaborators;

    public Note() {
        this.content = "";
    }

    public Note(String content, Long ownerId) {
        this.content = content;
        this.ownerId = ownerId;
    }

    public Note (String content)
    {
        this.content = content;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public Long getOwnerId()
    {
        return ownerId;
    }

    public void setOwnerId(Long ownerId)
    {
        this.ownerId = ownerId;
    }

    public List<Account> getCollaborators()
    {
        return collaborators;
    }

    public void setCollaborators(List<Account> collaborators)
    {
        this.collaborators = collaborators;
    }
}
