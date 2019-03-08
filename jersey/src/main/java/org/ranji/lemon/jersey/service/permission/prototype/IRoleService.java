package org.ranji.lemon.jersey.service.permission.prototype;

import org.ranji.lemon.core.service.prototype.IGenericService;
import org.ranji.lemon.jersey.model.permission.Role;

public interface IRoleService extends IGenericService<Role, Long>{
	//-- 除了父接口的方法，还自定义了两个方法
	
    //添加角色-权限之间关系
    public void grantPermissions(Long roleId, Long... permissionIds);
    //移除角色-权限之间关系
    public void removePermissions(Long roleId, Long... permissionIds);
}