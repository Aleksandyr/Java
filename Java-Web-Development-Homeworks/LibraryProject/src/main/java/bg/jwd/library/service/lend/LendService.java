package bg.jwd.library.service.lend;

import java.text.ParseException;
import java.util.List;

import bg.jwd.library.dto.lend.LendBookInfo;

public interface LendService {

	Boolean lendBook(Long userId, Long bookId, String dateOfLending, String dateOfReturn) throws ParseException;

	List<LendBookInfo> allLendsBook() throws ParseException;
}
