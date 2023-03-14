package demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.TweetDao;
import demo.entity.TweetEntity;
import demo.form.TweetForm;

@Service
public class AddTweetService {
	@Autowired
	TweetDao tweetDao;
	
	public void save(TweetForm tweetForm) {
		TweetEntity tweet = new TweetEntity();
		tweet.setContent(tweetForm.getContent());
		tweet.setUser_id(tweetForm.getUser_id());
		tweetDao.save(tweet);
	}
}
