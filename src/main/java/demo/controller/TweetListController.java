package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.entity.TweetEntity;
import demo.service.TweetListService;

@Controller
@RequestMapping("/minitwitter/tweet-list")
public class TweetListController {
	@Autowired
	private TweetListService tweetListService;
	
	@Autowired
	private UserSession userSession;
	
	@GetMapping
	public String findAll(Model model) {
		List<TweetEntity> tweetList = tweetListService.findAll();
		model.addAttribute("tweetList", tweetList);
		model.addAttribute("userSession", userSession);
		return "tweet-list";
	}

}
