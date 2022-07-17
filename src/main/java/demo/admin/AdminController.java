package demo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.mapper.UserMapper;

@Controller
@RequestMapping("/minitwitter/admin")
public class AdminController {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping("/register")
	public String registerUser() {
		userMapper.insert("user001", passwordEncoder.encode("pass001"));
		userMapper.insert("user002", passwordEncoder.encode("pass002"));
		userMapper.insert("user003", passwordEncoder.encode("pass003"));
		return "login";
	}
}
