package org.ranji.lemon.jersey.mapper.permission;

import org.ranji.lemon.core.mapper.GenericMapper;
import org.ranji.lemon.jersey.model.permission.Permission;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionMapper extends GenericMapper<Permission,Long> {
	
}
