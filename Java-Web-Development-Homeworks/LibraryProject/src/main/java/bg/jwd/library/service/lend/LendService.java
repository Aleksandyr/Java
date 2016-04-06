package bg.jwd.library.service.lend;

import java.text.ParseException;

public interface LendService {

	Boolean lendBook(Long userId, Long bookId, String dateOfLending, String dateOfReturn) throws ParseException;

}
