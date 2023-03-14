package demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import demo.service.UserService;
import demo.entity.UserEntity;
import demo.form.UserForm;

@Controller
@RequestMapping("/minitwitter/login")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserSession userSession;
	
	public LoginController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public String show() {
		return "login";
	}
	
	@PostMapping
	public String findUser(@Validated UserForm form, BindingResult bindingResult, Model model, HttpSession session) {
		
		//ユーザ名またはパスワードが入力されていなかった場合ログイン画面にフォワード
		if (bindingResult.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : bindingResult.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			model.addAttribute(form);
			return "login";
		}
		
		//ログイン情報が取得できなかった場合ログイン画面いフォワード
		UserEntity user = userService.findUser(form);
//		System.out.println(user);
		if (user == null) {
			List<String> errorList = new ArrayList<String>();
			errorList.add("ユーザ名もしくはパスワードが間違っています");
			model.addAttribute("validationError", errorList);
			model.addAttribute(form);
			return "login";
		}
		
		//セッションクラスにユーザ情報を退避
		userSession.setUserForm(form);
		
		session.setAttribute("user", user);
		return "redirect:/minitwitter/tweet-list";
		

	}
}
