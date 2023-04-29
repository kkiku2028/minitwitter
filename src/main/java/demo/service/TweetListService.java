package demo.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
		List<TweetEntity> tweetEntityList = tweetDao.findAll();
		
		// ツイート作成時刻をTimestamp型からString型に変換
		for (TweetEntity tweetEntity : tweetEntityList) {
			Timestamp createTime = tweetEntity.getCreate_time();
			SimpleDateFormat smplDatFrmt = new SimpleDateFormat("yyyy/MM/dd");
			String stringTime = smplDatFrmt.format(createTime);
			tweetEntity.setCreateTimeString(stringTime);
		}
		return tweetEntityList;
	}
}
