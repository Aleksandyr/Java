package bg.jwd.library.dao.authority;

import java.util.List;

import bg.jwd.library.entity.user.Authority;

public interface AuthorityDao {
	Boolean addUserAuthority(Long userId, int authorityId);

	List<Authority> getAllAuthorities();
}
