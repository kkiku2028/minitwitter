package demo.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import demo.entity.UserEntity;
import demo.form.UserForm;
import lombok.Data;

@Component
@Data
@SessionScope
public class UserSession {
	private Integer id;
	private Integer user_id;
	private String username;
	private String password;
	
	UserForm userForm;
	UserEntity userEntity;
}
