package demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @see <a href="https://qiita.com/yamateion/items/c1affc4fa8defa814a41">...</a>
 */
@EnableWebSecurity
public class WebSecurityConfig {
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.formLogin(login -> login
				.loginProcessingUrl("/minitwitter/login")
				.loginPage("/minitwitter/login")
				.defaultSuccessUrl("/minitwitter/tweet-list")
				.failureUrl("/minitwitter/login")
				.permitAll()
		).logout(logout -> logout
				.logoutSuccessUrl("/login")
		).authorizeHttpRequests(auth -> auth
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations())
				.permitAll()
				.mvcMatchers("/minitwitter/login")
				.permitAll()
				.anyRequest()
				.authenticated()
		);
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
}
