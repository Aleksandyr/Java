package bg.jwd.library.entity.book;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import bg.jwd.library.entity.user.AutoUser;

@Entity
@Table(name = "BOOKS")
public class Book implements Serializable {

	private static final long serialVersionUID = 315247235922550809L;

	@Id
	@Column(name = "ID")
	private long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "AUTHOR")
	private String author;

	@Column(name = "YEAR_OF_POUBLISHING")
	private String yearOfPoublishing;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "LENDS", joinColumns = {
			@JoinColumn(name = "BOOK_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "USER_ID", referencedColumnName = "ID") })
	private List<AutoUser> users;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getYearOfPoublishing() {
		return yearOfPoublishing;
	}

	public void setYearOfPoublishing(String yearOfPoublishing) {
		this.yearOfPoublishing = yearOfPoublishing;
	}

	public List<AutoUser> getUsers() {
		return users;
	}

	public void setUsers(List<AutoUser> users) {
		this.users = users;
	}

}
