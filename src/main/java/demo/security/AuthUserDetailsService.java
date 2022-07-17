package demo.security;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import demo.domain.User;

@Service
public class AuthUserDetailsService implements UserDetailsService {
	@Autowired
	LoginMapper loginMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUser = Optional.ofNullable(loginMapper.findUserByName(username))
							.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
		if (optionalUser.isEmpty()) {
			throw new UsernameNotFoundException("User Not Found");
		}
		User user = optionalUser.get();
		return new AuthUserDetails(user, getAuthorities(user));
	}
	
	private Collection<GrantedAuthority> getAuthorities(User user) {
		return AuthorityUtils.createAuthorityList("ROLE_USER");
	}
}
