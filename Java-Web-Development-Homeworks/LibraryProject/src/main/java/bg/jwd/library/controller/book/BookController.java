package bg.jwd.library.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.library.constants.UrlConstants;
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
}
