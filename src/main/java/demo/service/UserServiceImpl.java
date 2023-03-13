package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.domain.User;
import demo.repository.UserRepository;
import demo.form.LoginForm;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findUser(LoginForm form) {
		User user = new User();
		user.setUsername(form.getUsername());
		user.setPassword(form.getPassword());
		return userRepository.findUser(user);
	}
}
