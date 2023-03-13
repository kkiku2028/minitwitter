package demo.repository;

import demo.domain.User;

public interface UserRepository {
	User findUser(User user);
}
