package bg.jwd.webBank.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import bg.jwd.webBank.database.WebBankDatabase;
import bg.jwd.webBank.entities.Database;
import bg.jwd.webBank.entities.User;

public class UserDetailsServiceImpl implements UserDetailsService {

	private WebBankDatabase db;

	public UserDetailsServiceImpl() {
		db = Database.getDatabase();
		this.accUsers();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// List<GrantedAuthority> authorities = new ArrayList<>();
		// authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		// authorities.add(new SimpleGrantedAuthority("ROLE_BANK_EMPLOYEE"));
		// User user = this.db.getUser(username);

		// Password: 123456
		return this.db.getUser(username);
	}

	private void accUsers() {
		List<GrantedAuthority> userAuthoritie = new ArrayList<>();
		userAuthoritie.add(new SimpleGrantedAuthority("ROLE_USER"));

		List<GrantedAuthority> bankEmployeeAuthoritie = new ArrayList<>();
		bankEmployeeAuthoritie.add(new SimpleGrantedAuthority("ROLE_BANK_EMPLOYEE"));

		User onlyUser = new User("user", "e10adc3949ba59abbe56e057f20f883e", userAuthoritie);
		User bankEmployee = new User("employee", "e10adc3949ba59abbe56e057f20f883e", bankEmployeeAuthoritie);
		this.db.addUser(onlyUser);
		this.db.addUser(bankEmployee);
	}

}