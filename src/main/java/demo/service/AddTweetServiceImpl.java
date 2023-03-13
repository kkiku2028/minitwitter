package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.domain.Tweet;
import demo.form.TweetForm;
import demo.repository.TweetRepository;

@Service
public class AddTweetServiceImpl implements AddTweetService {
	@Autowired
	TweetRepository tweetRepository;
	
	@Override
	public void save(TweetForm tweetForm) {
		Tweet tweet = new Tweet();
		tweet.setContent(tweetForm.getContent());
		tweet.setUser_id(tweetForm.getUser_id());
		tweetRepository.save(tweet);
	}
}
