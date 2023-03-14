package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.TweetDao;

@Service
public class DeleteTweetService {
	@Autowired
	TweetDao tweetRepository;

	public int delete(Integer id) {
		return tweetRepository.delete(id);
	}
}
