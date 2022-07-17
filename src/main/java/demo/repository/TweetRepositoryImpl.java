package demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.domain.Tweet;
import demo.mapper.TweetMapper;

@Repository
public class TweetRepositoryImpl implements TweetRepository {
	
	@Autowired
	public TweetMapper tweetMapper;
	
	@Override
	public List<Tweet> findAll() {
		return tweetMapper.findAll();
	}
	
	@Override
	public int save(Tweet tweet) {
		return tweetMapper.save(tweet);
	}
	
	@Override
	public int delete(Integer id) {
		return tweetMapper.delete(id);
	}
}
