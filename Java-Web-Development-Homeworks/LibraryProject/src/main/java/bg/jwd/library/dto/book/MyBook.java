package bg.jwd.library.dto.book;

import java.io.Serializable;

public class MyBook implements Serializable {

	private static final long serialVersionUID = 1423839051291723609L;

	private Long id;

	private Long bookId;

	private String name;

	private String author;

	private String yearOfPoublishing;

	private String dateOfLending;

	private String dateOfReturn;

	public MyBook(Long id, Long bookId, String name, String author, String yearOfPoublishing, String dateOfLending,
			String dateOfReturn) {
		this.id = id;
		this.bookId = bookId;
		this.name = name;
		this.author = author;
		this.yearOfPoublishing = yearOfPoublishing;
		this.dateOfLending = dateOfLending;
		this.dateOfReturn = dateOfReturn;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
}