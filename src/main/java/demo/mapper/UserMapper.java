package demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import demo.domain.User;

@Mapper
public interface UserMapper {
	User findUser(User user);
}
