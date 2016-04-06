package bg.jwd.library.service.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.jwd.library.dao.book.BookDao;
import bg.jwd.library.entity.book.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao BookDao;

	@Override
	public List<Book> getAllBooks() {
		return BookDao.getAllBooks();
	}
}
