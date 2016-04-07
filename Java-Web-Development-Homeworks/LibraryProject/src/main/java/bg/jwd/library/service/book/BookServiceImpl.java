package bg.jwd.library.service.book;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.jwd.library.dao.book.BookDao;
import bg.jwd.library.dto.book.MyBook;
import bg.jwd.library.entity.book.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao BookDao;

	@Override
	public List<Book> getAllBooks() {
		return BookDao.getAllBooks();
	}

	@Override
	public Book getBookById(Long id) {
		return BookDao.getBookById(id);
	}

	@Override
	public Boolean editBookFromAdminById(Long id, Book book) throws ParseException {
		return BookDao.editBookFromAdminById(id, book);
	}

	@Override
	public Boolean deleteBookById(Long id) {
		return BookDao.deleteBookById(id);
	}

	@Override
	public Boolean addBook(Book book) throws ParseException {
		return BookDao.addBook(book);
	}

	@Override
	public List<MyBook> getMyBooks(Long userId) throws ParseException {
		return BookDao.getMyBooks(userId);
	}
}
