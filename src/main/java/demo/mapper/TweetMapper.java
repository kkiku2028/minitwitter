package demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import demo.domain.Tweet;

@Mapper
public interface TweetMapper {
	
	@Select("select * from tweet")
	List<Tweet> findAll();
	
	int save(Tweet tweet);
	int delete(Integer id);
}
