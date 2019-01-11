package org.ranji.lemon.jersey.service.permission.impl;

import org.ranji.lemon.core.service.impl.GenericServiceImpl;
import org.ranji.lemon.jersey.mapper.permission.UserMapper;
import org.ranji.lemon.jersey.model.permission.User;
import org.ranji.lemon.jersey.service.permission.prototype.IUserService;
import org.springframework.stereotype.Service;

@Service("JerseyUserServiceImpl") //-- 为解决其他项目中也有项目的类名，则利用@Autowired自动注入冲突的问题
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements IUserService{
	
	//-- 测试在接口中自定义方法
	
	@Override
	public void selfMethod(User user) {
		((UserMapper)mapper).selfMethod(user);
	}
	
}

