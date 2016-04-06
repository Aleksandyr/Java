package bg.jwd.library.entity.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LENDS")
public class Lend {

	@Id
	@Column(name = "ID")
	private long id;

	@Column(name = "DATE_OF_LENDING")
	private String dateOfLending;

	@Column(name = "DATE_OF_RETURN")
	private String dateOfReturn;
}
