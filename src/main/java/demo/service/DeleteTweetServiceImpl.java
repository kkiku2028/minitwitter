package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.repository.TweetRepository;

@Service
public class DeleteTweetServiceImpl implements DeleteTweetService {
	@Autowired
	TweetRepository tweetRepository;
	
	@Override
	public int delete(Integer id) {
		return tweetRepository.delete(id);
	}
}
