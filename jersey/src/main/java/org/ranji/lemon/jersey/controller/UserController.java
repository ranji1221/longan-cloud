package org.ranji.lemon.jersey.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ranji.lemon.core.pagination.PagerModel;
import org.ranji.lemon.core.system.SystemContext;
import org.ranji.lemon.core.util.JsonUtil;
import org.ranji.lemon.jersey.model.permission.User;
import org.ranji.lemon.jersey.service.permission.prototype.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/tolist")
	public ModelAndView toList(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("backend/permission/user/list");
		return mv;
	}
	
	@RequestMapping(value="/list")
	@ResponseBody
	public String list(@RequestParam("page") int page,@RequestParam("limit") int limit) {
		return getUser(page, limit);
	}
	
	@RequestMapping(value="/update",method =RequestMethod.POST)
	@ResponseBody
	public String udpate(@RequestBody String userJSON)throws Exception{
		System.out.println(userJSON);
		User u = JsonUtil.jsonToPojo(userJSON, User.class);
		System.out.println(u.getId());
		System.out.println(u.getUsername());
		System.out.println(u.getPassword());
		return "";
	}
	
	
	@RequestMapping(value="/delete",method =RequestMethod.POST)
	@ResponseBody
	public String delete(@RequestParam(value = "ids[]")  Integer[]  ids){
		List<Integer> list= Arrays.asList(ids); 
		
		userService.deleteByIDS(list);
		
		return "{access: success}";
		
	}
	
	//-- 获取用户
	private String getUser(int page, int limit){
		SystemContext.setPage(page);
		SystemContext.setPageSize(limit);
		PagerModel<User> pm = userService.findPaginated();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("count", pm.getTotal());
		map.put("msg", "users");
		map.put("code", 0);
		map.put("data", pm.getData());
		return JsonUtil.objectToJson(map);
	}
}
