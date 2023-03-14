package demo.dao;

import org.apache.ibatis.annotations.Mapper;

import demo.entity.UserEntity;

@Mapper
public interface UserDao {
	UserEntity findUser(UserEntity user);
}
