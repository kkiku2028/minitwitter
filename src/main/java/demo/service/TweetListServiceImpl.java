package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.domain.Tweet;
import demo.repository.TweetRepository;

@Service
public class TweetListServiceImpl implements TweetListService {
	@Autowired
	TweetRepository tweetRepository;
	
	@Override
	public List<Tweet> findAll() {
		return tweetRepository.findAll();
	}
}
