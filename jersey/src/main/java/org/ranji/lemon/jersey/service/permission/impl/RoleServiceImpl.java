package org.ranji.lemon.jersey.service.permission.impl;

import org.ranji.lemon.core.service.impl.GenericServiceImpl;
import org.ranji.lemon.jersey.mapper.permission.RoleMapper;
import org.ranji.lemon.jersey.model.permission.Role;
import org.ranji.lemon.jersey.service.permission.prototype.IRoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl  extends GenericServiceImpl<Role, Long> implements IRoleService {

	@Override
	public void grantPermissions(Long roleId, Long... permissionIds) {
		((RoleMapper)mapper).grantPermissions(roleId,permissionIds);
	}

	@Override
	public void removePermissions(Long roleId, Long... permissionIds) {
		((RoleMapper)mapper).removePermissions(roleId,permissionIds);
	}

}
