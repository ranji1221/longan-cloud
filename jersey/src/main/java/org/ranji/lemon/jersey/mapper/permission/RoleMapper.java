package org.ranji.lemon.jersey.mapper.permission;

import org.apache.ibatis.annotations.Param;
import org.ranji.lemon.core.mapper.GenericMapper;
import org.ranji.lemon.jersey.model.permission.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper extends GenericMapper<Role, Long>{
	//-- 除了继承自父接口的方法，自己还定义两个接口方法
	
	/**
	 * 给某角色授权
	 * @param roleId
	 * @param permissionIds
	 */
    public void grantPermissions(@Param("roleId") Long roleId, @Param("permissionIds") Long... permissionIds);
    /**
     * 为某角色解除权限
     * @param roleId
     * @param permissionIds
     */
    public void removePermissions(@Param("roleId") Long roleId, @Param("permissionIds") Long... permissionIds);
}
