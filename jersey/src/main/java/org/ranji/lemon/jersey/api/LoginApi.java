package org.ranji.lemon.jersey.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.ranji.lemon.core.util.JsonUtil;
import org.ranji.lemon.jersey.model.permission.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 提供登录模块的对外接口，例如：Vue的前端分离调用
 * @author RanJi
 *
 */
@Controller 
@RequestMapping("/longan-api")
public class LoginApi {
	
	@RequestMapping("/test1")
	@ResponseBody
	public String test1(){
		System.out.println(SecurityUtils.getSubject().getSession().getId());
		return "test1";
	}
	
	/**
	 * 适合Vue的登录接口，请求表单的数据参数类型为Json对象类型，故而使用了@RequsetBody标注
	 * @param user	
	 * @param session
	 * @param request
	 * @return  
	 * @throws Exception
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody User user, HttpSession session,HttpServletRequest request){
		String msg = JsonUtil.toJsonByProperty("login", "failure");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
		try{
			subject.login(token);
System.out.println(subject.getSession().getId());
System.out.println(session.getId());
			msg = JsonUtil.toJsonByProperty("login", "success");
		} catch (AuthenticationException e){
			//e.printStackTrace();
		} 
		return msg;
	}
}
