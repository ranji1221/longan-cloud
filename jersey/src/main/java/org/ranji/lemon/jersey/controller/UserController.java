package org.ranji.lemon.jersey.controller;

import java.util.HashMap;
import java.util.Map;

import org.ranji.lemon.core.pagination.PagerModel;
import org.ranji.lemon.core.system.SystemContext;
import org.ranji.lemon.core.util.JsonUtil;
import org.ranji.lemon.jersey.model.permission.User;
import org.ranji.lemon.jersey.service.permission.prototype.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/list")
	@ResponseBody
	public String list(@RequestParam("page") int page,@RequestParam("limit") int limit) {
		SystemContext.setOffset((page-1) * limit);
		SystemContext.setPageSize(limit);
		PagerModel<User> pm = userService.findPaginated();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("count", pm.getTotal());
		map.put("msg", "users");
		map.put("code", 0);
		map.put("data", pm.getData());
		return JsonUtil.objectToJson(map);
	}
	
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable int id) {
		ModelAndView mv = new ModelAndView(); 
		userService.delete(id);
		mv.setViewName("redirect:/user/list");
		return mv;
	}

}
