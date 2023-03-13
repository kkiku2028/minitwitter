package demo.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import demo.domain.User;
import demo.mapper.UserMapper;

@Repository
public class UserRepositoryImpl implements UserRepository {
	private final SqlSessionTemplate sqlSessionTemplate;
	
	public UserRepositoryImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public User findUser(User user) {
		return this.sqlSessionTemplate.getMapper(UserMapper.class).findUser(user);
	}

}
