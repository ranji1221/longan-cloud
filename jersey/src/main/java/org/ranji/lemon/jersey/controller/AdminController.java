package org.ranji.lemon.jersey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	@RequestMapping("/admin")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("backend/index");
		return mv;
	}  
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("backend/login");
		return mv;
	}
	
	
}
