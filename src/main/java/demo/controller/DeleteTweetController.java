package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.service.DeleteTweetService;

@Controller
public class DeleteTweetController {

	@Autowired
	DeleteTweetService deleteTweetService;
	
	@RequestMapping(path = "minitwitter/delete/{id}", method = RequestMethod.POST)
	public String show(Model model, @PathVariable("id") Integer id) {
		deleteTweetService.delete(id);
		return "redirect:/minitwitter/tweet-list";
	}
}
