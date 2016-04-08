package bg.jwd.library.constants;

public class UrlConstants {

	private UrlConstants() {
	}

	// CRUD operations urls
	public static final String ADD_URL = "/add";
	public static final String UPDATE_URL = "/edit";
	public static final String DELETE_URL = "/delete";
	public static final String LIST_URL = "/all";

	// Home url
	public static final String BASE_HOME_URL = "/home";
	public static final String HOME_URL = "/";
	public static final String HOME_INACTIVE_URL = "/inactive";

	// Account urls
	public static final String BASE_ACCOUNT_URL = "/account";
	public static final String USER_LOGIN_URL = "/login";
	public static final String USER_LOGOUT_URL = "/logout";

	// User urls
	public static final String BASE_USER_URL = "/users";

	// Prifle urls
	public static final String BASE_PROFILE_URL = "/profile";
	public static final String SHOW_PROFILE_URL = "/show";

	// Books urls
	public static final String BASE_BOOK_URL = "/books";
	public static final String MY_BOOKS_URL = "/my";

	// Books lend urls
	public static final String BOOK_LEND_URL = "/lends";
}
