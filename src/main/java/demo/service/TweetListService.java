package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.TweetDao;
import demo.entity.TweetEntity;

@Service
public class TweetListService  {
	@Autowired
	TweetDao tweetDao;

	public List<TweetEntity> findAll() {
		return tweetDao.findAll();
	}
}
