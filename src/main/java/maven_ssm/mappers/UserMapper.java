package maven_ssm.mappers;

import maven_ssm.entity.User;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository("userMapper")
public interface UserMapper{

	User findUserById(@Param("id") Long id);

	void addUser(User user);
	
}
