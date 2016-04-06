package bg.jwd.library.dao.authority;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bg.jwd.library.entity.user.Authority;

@Repository
public class AuthorityDaoImpl implements AuthorityDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Boolean addUserAuthority(Long userId, int authorityId) {
		Query addUser = entityManager
				.createNativeQuery("INSERT INTO user_authority (user_id, authority_id)" + "VALUES(?, ?)");

		addUser.setParameter(1, userId).setParameter(2, authorityId).executeUpdate();

		return true;
	}

	@Override
	public List<Authority> getAllAuthorities() {
		Query getAllAuthoritiesQuery = entityManager.createNativeQuery("SELECT * FROM authorities", Authority.class);

		List<Authority> authorities = getAllAuthoritiesQuery.getResultList();

		return authorities;
	}

}
