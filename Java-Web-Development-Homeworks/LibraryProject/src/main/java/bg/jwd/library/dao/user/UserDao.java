package bg.jwd.library.dao.user;

import java.util.List;

import bg.jwd.library.entity.user.AutoUser;

public interface UserDao {
	AutoUser getUser(String username);

	List<AutoUser> getUsers(String username, String status);
}