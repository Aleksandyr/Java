package bg.jwd.library.dao.book;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

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

}
