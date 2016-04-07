package bg.jwd.library.service.book;

import java.text.ParseException;
import java.util.List;

import bg.jwd.library.dto.book.MyBook;
import bg.jwd.library.entity.book.Book;

public interface BookService {
	List<Book> getAllBooks();

	Book getBookById(Long id);

	Boolean editBookFromAdminById(Long id, Book book) throws ParseException;

	Boolean deleteBookById(Long id);

	Boolean addBook(Book book) throws ParseException;

	List<MyBook> getMyBooks(Long userId) throws ParseException;
}
