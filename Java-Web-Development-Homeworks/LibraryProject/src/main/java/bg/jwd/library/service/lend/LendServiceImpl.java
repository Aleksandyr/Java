package bg.jwd.library.service.lend;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.jwd.library.dao.lend.LendDao;

@Service
public class LendServiceImpl implements LendService {

	@Autowired
	private LendDao lendDao;

	@Override
	public Boolean lendBook(Long userId, Long bookId, String dateOfLending, String dateOfReturn) throws ParseException {
		return this.lendDao.lendBook(userId, bookId, dateOfLending, dateOfReturn);
	}

}