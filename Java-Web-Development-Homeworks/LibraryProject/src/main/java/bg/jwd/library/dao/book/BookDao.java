package bg.jwd.library.dao.book;

import java.text.ParseException;
import java.util.List;

import bg.jwd.library.entity.book.Book;

public interface BookDao {
	List<Book> getAllBooks();

	Book getBookById(Long id);

	Boolean editBookFromAdminById(Long id, Book book) throws ParseException;

	Boolean deleteBookById(Long id);
}
