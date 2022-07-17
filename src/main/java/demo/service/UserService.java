package demo.service;

import demo.domain.User;
import demo.form.LoginForm;

public interface UserService {
	User findUser(LoginForm form);
}
