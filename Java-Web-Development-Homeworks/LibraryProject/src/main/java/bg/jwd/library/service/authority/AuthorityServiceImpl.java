package bg.jwd.library.service.authority;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.jwd.library.dao.authority.AuthorityDao;
import bg.jwd.library.entity.user.Authority;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityDao authorityDao;

	@Override
	public Boolean addUserAuthority(Long userId, int authorityId) {
		return this.authorityDao.addUserAuthority(userId, authorityId);
	}

	@Override
	public List<Authority> getAllAuthorities() {
		return this.authorityDao.getAllAuthorities();
	}
}
