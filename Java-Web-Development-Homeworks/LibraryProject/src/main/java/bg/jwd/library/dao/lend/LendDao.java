package bg.jwd.library.dao.lend;

import java.text.ParseException;
import java.util.List;

import bg.jwd.library.dto.lend.LendBookInfo;

public interface LendDao {
	Boolean lendBook(Long userId, Long bookId, String dateOfLending, String dateOfReturn) throws ParseException;

	List<LendBookInfo> allLendsBook() throws ParseException;
}
