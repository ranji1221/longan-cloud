package org.ranji.lemon.jersey.test.permission;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ranji.lemon.jersey.JerseyApplication;
import org.ranji.lemon.jersey.model.permission.Permission;
import org.ranji.lemon.jersey.service.permission.prototype.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=JerseyApplication.class)  //-- 指定Spring-Boot的启动类
public class PermissionTest {
	
	@Autowired
	IPermissionService permissionService;
	
	@Test
	public void testAdd(){
		Permission perm = new Permission("user:create","添加用户",Boolean.TRUE);
		permissionService.save(perm);
	}
	
	@Test
	public void testDelete(){
		permissionService.delete(1L);
	}
}
