package org.ranji.lemon.jersey.service.permission.impl;

import org.ranji.lemon.core.service.impl.GenericServiceImpl;
import org.ranji.lemon.jersey.model.permission.Permission;
import org.ranji.lemon.jersey.service.permission.prototype.IPermissionService;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl extends GenericServiceImpl<Permission, Long> implements IPermissionService{

}
