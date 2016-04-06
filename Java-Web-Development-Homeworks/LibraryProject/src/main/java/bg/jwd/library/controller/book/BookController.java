package bg.jwd.library.controller.book;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.library.constants.UrlConstants;
import bg.jwd.library.entity.book.Book;
import bg.jwd.library.security.User;
import bg.jwd.library.service.book.BookService;

@Controller
@RequestMapping(UrlConstants.BASE_BOOK_URL)
@Secured("ROLE_ADMIN")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = UrlConstants.ALL_BOOKS_URL, method = RequestMethod.GET)
	public String getAllBooksPage(Model model) {

		model.addAttribute("books", bookService.getAllBooks());

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();

		model.addAttribute("username", user.getUsername());

		return "/book/allBooks";
	}

	@RequestMapping(value = UrlConstants.EDIT_BOOKS_URL + "/{id}", method = RequestMethod.GET)
	public String editBookPage(@PathVariable("id") long bookId, Model model) {

		Book book = this.bookService.getBookById(bookId);

		if (book != null) {
			model.addAttribute("book", book);

			return "/book/editBook";

		} else {
			return "redirect:" + UrlConstants.BASE_HOME_URL + UrlConstants.HOME_URL;
		}
	}

	@RequestMapping(value = UrlConstants.EDIT_BOOKS_URL + "/{id}", method = RequestMethod.POST)
	public String editBook(@PathVariable("id") long bookId, Model model, @ModelAttribute("book") Book book)
			throws ParseException {

		Boolean isEdited = this.bookService.editBookFromAdminById(bookId, book);

		if (isEdited == true) {
			return "redirect:" + UrlConstants.BASE_BOOK_URL + UrlConstants.ALL_BOOKS_URL;

		} else {
			return "/book/editBook";
		}
	}

	@RequestMapping(value = UrlConstants.DELETE_USER_URL + "/{id}", method = RequestMethod.GET)
	public String deteleBookPage(@PathVariable("id") long bookId, Model model) {

		Book book = this.bookService.getBookById(bookId);

		if (book != null) {
			model.addAttribute("book", book);

			return "/book/deleteBook";

		} else {
			return "redirect:" + UrlConstants.BASE_HOME_URL + UrlConstants.HOME_URL;
		}
	}

	@RequestMapping(value = UrlConstants.DELETE_USER_URL + "/{id}", method = RequestMethod.POST)
	public String deleteBook(@PathVariable("id") long bookId, Model model) {

		Boolean isDeleted = this.bookService.deleteBookById(bookId);

		if (isDeleted == true) {
			return "redirect:" + UrlConstants.BASE_BOOK_URL + UrlConstants.ALL_BOOKS_URL;

		} else {
			return "/book/deleteBook";
		}
	}

}
