package org.ranji.lemon.jersey.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	//-- 测试同时要求user、admin角色
	//--@RequiresRoles({"user","min"})
	@RequiresPermissions({"index"})
	@RequestMapping("/admin")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("backend/index");
		return mv;
	}  
	
}
