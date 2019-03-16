package org.ranji.lemon.jersey.api;

import java.util.List;

import org.ranji.lemon.core.util.JsonUtil;
import org.ranji.lemon.jersey.model.permission.User;
import org.ranji.lemon.jersey.service.permission.prototype.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/longan-api")
public class UserApi {
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/users")
	@ResponseBody
	public String list() {
		List<User> users = userService.findAll();
		System.out.println(JsonUtil.objectToJson(users));
		return JsonUtil.objectToJson(users);
	}
}
