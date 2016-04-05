package bg.jwd.library.dao.user;

import java.text.ParseException;
import java.util.List;

import bg.jwd.library.entity.user.AutoUser;

public interface UserDao {
	AutoUser getUser(String username);

	List<AutoUser> getAllUsers();

	List<AutoUser> getUsers(String username, String status);

	AutoUser getUserById(Long id);

	AutoUser getUserByUsername(String username);

	Boolean deleteUserById(Long id);

	Boolean editUserFromAdminById(Long id, int status);

	Boolean addUser(AutoUser user) throws ParseException;
}
