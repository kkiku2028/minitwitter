package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.UserDao;
import demo.entity.UserEntity;
import demo.form.UserForm;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	
	public UserEntity findUser(UserForm form) {
		UserEntity user = new UserEntity();
		user.setUsername(form.getUsername());
		user.setPassword(form.getPassword());
		return userDao.findUser(user);
	}
}
