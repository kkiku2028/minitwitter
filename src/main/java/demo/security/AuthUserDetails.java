package demo.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class AuthUserDetails extends User {
	private static final long serialVersionUID = 1L;
	private final demo.domain.User user;
	
	public AuthUserDetails(demo.domain.User user, Collection<GrantedAuthority> authorities) {
		super(user.getUsername(), user.getPassword(), authorities);
		this.user = user;
	}
	
	public demo.domain.User getUser() {
		return user;
	}
}
