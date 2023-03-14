package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.form.TweetForm;
import demo.service.AddTweetService;

@Controller
@RequestMapping("minitwitter/add")
public class AddTweetController {

	@Autowired
	private AddTweetService addTweetService;
	
	@GetMapping
	public String show(Model model) {
		TweetForm form = new TweetForm();
		model.addAttribute(form);
		return "add";
	}
	
	@PostMapping
	public String create(TweetForm form) {

		addTweetService.save(form);
		return "redirect:/minitwitter/tweet-list";
	}
}
