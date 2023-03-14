package demo.security;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import demo.dao.UserDao;

@Mapper
public interface LoginMapper {
	@Select("select * from user where username = #{username}")
	public Optional<UserDao> findUserByName(String username);
}
