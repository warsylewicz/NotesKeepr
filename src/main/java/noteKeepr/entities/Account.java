package noteKeepr.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;

	private String lastName;

	private String userName;

	private String email;

	private String password;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Note> notes;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "account_roles", joinColumns = @JoinColumn(name = "accounts_id"),
			inverseJoinColumns = @JoinColumn(name = "roles_id"))
	private Set<Role> roles = new HashSet<>();

	public Account()
	{
	}

	@PreUpdate
	private void updateRoles()
	{
		System.out.println();
	}

	@PreRemove
	private void removeAccountFromNotesAndRoles()
	{
		for (Note note : notes)
		{
			note.getCollaborators().remove(this);
		}
		for (Role role : roles)
		{
			role.getAccounts().remove(this);
		}
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Set<Role> getRoles()
	{
		return roles;
	}

	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
	}

	public Set<Note> getNotes()
	{
		return notes;
	}

	public void setNotes(Set<Note> notes)
	{
		this.notes = notes;
	}
}
