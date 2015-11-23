package noteKeepr.models;

import java.util.Date;
import java.util.Set;

public class NoteDto
{
	private Long id;
	private String title;
	private String content;
	private Date dateCreated;
	private Date dateModified;
	private boolean isOwner;
	private Set<Long> collaborators;

	public NoteDto(Long id, String title, String content, boolean isOwner, Set<Long> collaborators)
	{
		this.id = id;
		this.title = title;
		this.content = content;
		this.isOwner = isOwner;
		this.collaborators = collaborators;
	}

	public NoteDto()
	{
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public boolean isOwner()
	{
		return isOwner;
	}

	public void setOwner(boolean owner)
	{
		isOwner = owner;
	}

	public Set<Long> getCollaborators()
	{
		return collaborators;
	}

	public void setCollaborators(Set<Long> collaborators)
	{
		this.collaborators = collaborators;
	}

	public Date getDateCreated()
	{
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated)
	{
		this.dateCreated = dateCreated;
	}

	public Date getDateModified()
	{
		return dateModified;
	}

	public void setDateModified(Date dateModified)
	{
		this.dateModified = dateModified;
	}
}
