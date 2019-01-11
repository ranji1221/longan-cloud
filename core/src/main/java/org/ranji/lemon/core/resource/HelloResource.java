package org.ranji.lemon.core.resource;

import org.ranji.lemon.core.annotation.SystemLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloResource {
	
	@SystemLog(value="测试")
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		System.out.println("执行方法中代码...");
		return "hello world";
	}
	
}
