package maven_ssm.service.impl;

import javax.annotation.Resource;

import maven_ssm.entity.User;
import maven_ssm.mappers.UserMapper;
import maven_ssm.service.UserService;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	public User findUserById(Long id) {
	
		return userMapper.findUserById(id);
	}

	public void addUser(User user) {
		userMapper.addUser(user);
	}
	
}
