package bg.jwd.webBank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bg.jwd.webBank.entities.User;

public class UserDaoImpl implements UserDao {

	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String USERNAME = "db";
	public static final String PASSWORD = "db";

	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public Boolean createUser(User user) {
		String sql = "INSERT INTO users (id, username, password, role) values (?,?,?,?)";

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setLong(1, 2);
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getRole());

			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
