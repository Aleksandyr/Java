package bg.jwd.library.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.jwd.library.dao.user.UserDao;
import bg.jwd.library.entity.user.AutoUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<AutoUser> getUsers(String username, String status) {
		return userDao.getUsers(username, status);
	}

	@Override
	public List<AutoUser> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public AutoUser getUserById(Long id) {
		return userDao.getUserById(id);
	}
}