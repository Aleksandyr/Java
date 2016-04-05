package bg.jwd.library.service.user;

import java.text.ParseException;
import java.util.List;

import bg.jwd.library.entity.user.AutoUser;

public interface UserService {
	List<AutoUser> getUsers(String username, String status);

	List<AutoUser> getAllUsers();

	AutoUser getUserById(Long id);

	AutoUser getUserByUsername(String username);

	Boolean deleteUserById(Long id);

	Boolean editUserFromAdminById(Long id, int status);

	Boolean addUser(AutoUser user) throws ParseException;
}