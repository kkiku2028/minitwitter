package demo.service;

import java.util.List;

import demo.domain.Tweet;

public interface TweetListService {
	List<Tweet> findAll();
}
