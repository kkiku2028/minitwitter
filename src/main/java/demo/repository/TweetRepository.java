package demo.repository;

import java.util.List;

import demo.domain.Tweet;

public interface TweetRepository {
	List<Tweet> findAll();
	int save(Tweet tweet);
	int delete(Integer id);
	
}
