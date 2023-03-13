package demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import demo.domain.User;

@Mapper
public interface UserMapper {
	User findUser(User user);
	
	@Insert("insert into user (username, password) values (#{username}, #{password})")
	void insert(String username, String password);
}
