package org.ranji.lemon.jersey.test.permission;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ranji.lemon.core.pagination.PagerModel;
import org.ranji.lemon.core.system.SystemContext;
import org.ranji.lemon.jersey.JerseyApplication;
import org.ranji.lemon.jersey.model.permission.User;
import org.ranji.lemon.jersey.service.permission.prototype.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=JerseyApplication.class)  //-- 指定Spring-Boot的启动类
public class UserTest {

	
	@Autowired
	private IUserService userService;
	
	@Test
	public void testFind(){
		/*
		List<User> users = userService.findAll();
		for (User user : users) {
			System.out.println(user);
		}
		
		User u = userService.find(31);
		System.out.println(u);
		
		u.setUsername("HaHa");
		u.setPassword("99999");
		u.setUpdateTime(DateUtil.now());
		userService.update(u);*/
		
		/*
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("username", "li");
		params.put("password", "1230");
		List<User> users = userService.findAll(params);
		for (User user : users) {
			System.out.println(user);
		}*/
		
		
		//-- 不带参数的分页查询
		/*
		SystemContext.setOffset(0);
		SystemContext.setPageSize(3);
		PagerModel<User> pm = userService.findPaginated();
		
		for (User user : pm.getData()) {
			System.out.println(user);
		}
		System.out.println(pm.getTotal());
		*/
		//-- 带参数的分页查询
		//-- 设置分页
		SystemContext.setOffset(0);
		SystemContext.setPageSize(3);
		//-- 设置参数
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("username", "li");
		params.put("password", "123");
		
		PagerModel<User> pm = userService.findPaginated(params);
		
		for (User user : pm.getData()) {
			System.out.println(user);
		}
		System.out.println(pm.getTotal());
	}
	
	
	
	@Test
	public void testSelfMethod(){
		User u = new User();
		u.setUsername("lisi");
		u.setPassword("123456");
		userService.selfMethod(u);
	}
	
	@Test
	public void testInsert(){
		for(int i=0; i<100; i++){
			User u = new User();
			u.setUsername("zhangsan"+i+1);
			u.setPassword("123"+i);
			userService.save(u);
		}
	}
	
	@Test
	public void testDelete(){
		//-- 删除单条记录
		//-- userService.delete(20);
		
		//-- 删除若干条记录
		/*List<Integer> ids = new ArrayList<Integer>();
		ids.add(23);
		ids.add(28);
		ids.add(30);
		ids.add(25);
		userService.deleteByIDS(ids);*/
		//-- 删除全部记录
		userService.deleteAll();
	}
	
}
