package bg.jwd.library.service.authority;

import java.util.List;

import bg.jwd.library.entity.user.Authority;

public interface AuthorityService {
	Boolean addUserAuthority(Long userId, int authorityId);

	List<Authority> getAllAuthorities();
}
