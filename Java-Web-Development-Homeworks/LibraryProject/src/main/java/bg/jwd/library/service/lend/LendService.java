package bg.jwd.library.service.lend;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import bg.jwd.library.dto.lend.LendBookInfo;

public interface LendService {

	Boolean addLendBook(Long userId, Long bookId, String dateOfLending, String dateOfReturn) throws ParseException;

	List<LendBookInfo> allLendsBook() throws ParseException;

	LendBookInfo getLendBook(Long lendId) throws ParseException;

	Boolean deleteLendBook(Long lendId);

	Boolean editLendBook(Long lendId, Date dateOfReturn);
}
