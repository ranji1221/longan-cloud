package org.ranji.lemon.jersey.test.permission;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ranji.lemon.jersey.JerseyApplication;
import org.ranji.lemon.jersey.model.permission.Role;
import org.ranji.lemon.jersey.service.permission.prototype.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=JerseyApplication.class)  //-- 指定Spring-Boot的启动类
public class RoleTest {
	
	@Autowired
	IRoleService roleService;
	
	@Test
	public void testAdd(){
		Role r = new Role("admin","管理员",Boolean.TRUE);
		roleService.save(r);
	}
	
	@Test
	public void testDelete(){
		roleService.delete(1L);
	}
	
	@Test
	public void testGrantPermissions(){
		Long roleId = 3L;	//-- 模拟ID为3的角色
		Long[] perms = {4L,2L,3L};	//-- 模拟ID为4、2、3的三个权限
		roleService.grantPermissions(roleId, perms);
	}
	
	@Test
	public void testRemovePermissions(){
		roleService.removePermissions(3L, new Long[]{2L,4L,3L,1L});
	}
}
