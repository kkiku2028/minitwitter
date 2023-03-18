package demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/minitwitter")
public class LogoutController {
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session, ModelAndView mv) {
		session.removeAttribute("user");
		mv.setViewName("login.html");
		return mv;
	}
}
