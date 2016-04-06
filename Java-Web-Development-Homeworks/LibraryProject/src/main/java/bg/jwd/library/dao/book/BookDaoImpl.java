package bg.jwd.library.dao.book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bg.jwd.library.entity.book.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Book> getAllBooks() {
		Query getAllBooksQuery = entityManager.createNativeQuery("SELECT * FROM books", Book.class);

		List<Book> books = getAllBooksQuery.getResultList();

		return books;
	}

	@Override
	public Book getBookById(Long id) {
		Query getBookById = entityManager.createNativeQuery("SELECT * FROM books WHERE id = ?", Book.class);
		getBookById.setParameter(1, id);

		List<Book> books = getBookById.getResultList();

		return books != null ? books.get(0) : null;
	}

	@Override
	@Transactional
	public Boolean editBookFromAdminById(Long id, Book book) throws ParseException {
		Query editBookFromAdmin = entityManager
				.createNativeQuery("UPDATE books SET name=?, author=?, year_of_poublishing=?  WHERE id=?");

		java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(book.getYearOfPoublishing());
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		editBookFromAdmin.setParameter(1, book.getName()).setParameter(2, book.getAuthor()).setParameter(3, sqlDate)
				.setParameter(4, book.getId()).executeUpdate();

		return true;
	}

	@Override
	@Transactional
	public Boolean deleteBookById(Long id) {
		Query deleteBookQuery = entityManager.createNativeQuery("DELETE FROM books WHERE id = ?");
		deleteBookQuery.setParameter(1, id).executeUpdate();

		return true;
	}

	@Override
	@Transactional
	public Boolean addBook(Book book) throws ParseException {
		Query addBook = entityManager
				.createNativeQuery("INSERT INTO books (name, author, year_of_poublishing)" + "VALUES(?, ?, ?)");

		java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(book.getYearOfPoublishing());
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		addBook.setParameter(1, book.getName()).setParameter(2, book.getAuthor()).setParameter(3, sqlDate)
				.executeUpdate();

		return true;
	}

}
