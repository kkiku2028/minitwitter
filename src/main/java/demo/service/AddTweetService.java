package demo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import demo.dao.TweetDao;
import demo.entity.TweetEntity;
import demo.form.TweetForm;

@Service
public class AddTweetService {
	@Autowired
	TweetDao tweetDao;

	public TweetEntity store(MultipartFile file, TweetForm tweetForm) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		TweetEntity tweetEntity = new TweetEntity(fileName, file.getContentType(), file.getBytes());
		tweetEntity.setContent(tweetForm.getContent());
		tweetEntity.setUser_id(tweetForm.getUser_id());
		return tweetDao.save(tweetEntity);
	}
	
	public void save(TweetForm tweetForm) {
		TweetEntity tweet = new TweetEntity();
		tweet.setContent(tweetForm.getContent());
		tweet.setUser_id(tweetForm.getUser_id());
		tweetDao.save(tweet);
	}
}
