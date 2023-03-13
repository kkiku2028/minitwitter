package demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import demo.entity.TweetEntity;

@Mapper
public interface TweetDao {
	List<TweetEntity> findAll();
	int save(TweetEntity tweet);
	int delete(Integer id);
	
}
