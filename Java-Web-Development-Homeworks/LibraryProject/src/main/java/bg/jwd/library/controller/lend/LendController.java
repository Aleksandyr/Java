package bg.jwd.library.controller.lend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.library.constants.UrlConstants;
import bg.jwd.library.entity.book.Book;
import bg.jwd.library.security.User;
import bg.jwd.library.service.book.BookService;
import bg.jwd.library.service.lend.LendService;

@Controller
@RequestMapping(UrlConstants.BASE_BOOK_URL + UrlConstants.BOOK_LEND_URL)
public class LendController {

	@Autowired
	private LendService lendService;

	@Autowired
	private BookService bookService;

	@RequestMapping(value = UrlConstants.BOOK_LEND_ADD_URL + "/{id}", method = RequestMethod.GET)
	public String lendBookPage(@PathVariable("id") long bookId, Model model) {

		Book book = this.bookService.getBookById(bookId);

		if (book != null) {
			model.addAttribute("book", book);
			String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
			model.addAttribute("dateToday", date);

			return "/book/lendBook";

		} else {
			return "redirect:" + UrlConstants.BASE_HOME_URL + UrlConstants.HOME_URL;
		}
	}

	@RequestMapping(value = UrlConstants.BOOK_LEND_ADD_URL + "/{id}", method = RequestMethod.POST)
	public String lendBook(@PathVariable("id") long bookId, HttpServletRequest request) throws ParseException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();

		Book book = this.bookService.getBookById(bookId);

		String getYearOfLending = request.getParameter("dateOfLending");
		String getDateOfReturn = request.getParameter("dateOfReturn");

		Boolean isLended = this.lendService.lendBook(user.getId(), book.getId(), getYearOfLending, getDateOfReturn);

		if (isLended == true) {
			return "redirect:" + UrlConstants.BASE_BOOK_URL + UrlConstants.ALL_BOOKS_URL;

		} else {
			return "/book/editBook";
		}
	}
}
