package bg.jwd.library.dto.lend;

import java.io.Serializable;

public class LendBookInfo implements Serializable {
	private static final long serialVersionUID = -1866782762304912715L;

	private String username;

	private String name;

	private String author;

	private String yearOfPoublishing;

	private String dateOfLending;

	private String dateOfReturn;

	public LendBookInfo(String username, String name, String author, String yearOfPoublishing, String dateOfLending,
			String dateOfReturn) {
		this.username = username;
		this.name = name;
		this.author = author;
		this.yearOfPoublishing = yearOfPoublishing;
		this.dateOfLending = dateOfLending;
		this.dateOfReturn = dateOfReturn;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getDateOfLending() {
		return dateOfLending;
	}

	public void setDateOfLending(String dateOfLending) {
		this.dateOfLending = dateOfLending;
	}

	public String getDateOfReturn() {
		return dateOfReturn;
	}

	public void setDateOfReturn(String dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}
}
