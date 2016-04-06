package bg.jwd.library.dao.lend;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LendDaoImpl implements LendDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Boolean lendBook(Long userId, Long bookId, String dateOfLending, String dateOfReturn) throws ParseException {
		Query addBook = entityManager.createNativeQuery(
				"INSERT INTO lends (user_id, book_id, date_of_lending, date_of_return)" + "VALUES(?, ?, ?, ?)");

		java.util.Date convertDateOfLendDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfLending);
		java.sql.Date sqlDateOfLend = new java.sql.Date(convertDateOfLendDate.getTime());

		java.util.Date convertDateOfReturn = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfReturn);
		java.sql.Date sqlDateOfReturn = new java.sql.Date(convertDateOfReturn.getTime());

		addBook.setParameter(1, userId).setParameter(2, bookId).setParameter(3, sqlDateOfLend)
				.setParameter(4, sqlDateOfReturn).executeUpdate();

		return true;
	}

}
