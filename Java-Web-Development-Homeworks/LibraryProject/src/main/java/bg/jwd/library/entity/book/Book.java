package bg.jwd.library.entity.book;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

}
