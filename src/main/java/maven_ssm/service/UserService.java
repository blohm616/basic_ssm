package maven_ssm.service;

import maven_ssm.entity.User;



public interface UserService {
	
	User findUserById(Long id);
	
	void addUser(User user);
}
