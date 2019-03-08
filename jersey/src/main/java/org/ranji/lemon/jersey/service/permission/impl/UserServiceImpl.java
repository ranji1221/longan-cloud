package org.ranji.lemon.jersey.service.permission.impl;

import java.util.Set;

import org.ranji.lemon.core.service.impl.GenericServiceImpl;
import org.ranji.lemon.jersey.mapper.permission.UserMapper;
import org.ranji.lemon.jersey.model.permission.Permission;
import org.ranji.lemon.jersey.model.permission.Role;
import org.ranji.lemon.jersey.model.permission.User;
import org.ranji.lemon.jersey.service.permission.prototype.IUserService;
import org.springframework.stereotype.Service;

@Service("JerseyUserServiceImpl") //-- 为解决其他项目中也有项目的类名，则利用@Autowired自动注入冲突的问题
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements IUserService{
	
	@Override
	public void changePassword(Long userId, String newPassword) {
		((UserMapper)mapper).changePassword(userId, newPassword);
	}

	@Override
	public void assignRoles(Long userId, Long... roleIds) {
		((UserMapper)mapper).assignRoles(userId, roleIds);
	}

	@Override
	public void relieveRoles(Long userId, Long... roleIds) {
		((UserMapper)mapper).relieveRoles(userId, roleIds);
	}

	@Override
	public User findByUsername(String username) {
		return ((UserMapper)mapper).findByUsername(username);
	}

	@Override
	public Set<Role> findRoles(String username) {
		return ((UserMapper)mapper).findRoles(username);
	}

	@Override
	public Set<Permission> findPermissions(String username) {
		return ((UserMapper)mapper).findPermissions(username);
	}
	
}

