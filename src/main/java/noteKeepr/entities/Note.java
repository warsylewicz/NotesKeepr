package noteKeepr.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Note implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;

    private Long ownerId;

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
}
