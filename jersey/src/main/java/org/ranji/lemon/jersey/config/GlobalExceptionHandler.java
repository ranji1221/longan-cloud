package org.ranji.lemon.jersey.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 配置全局的异常处理类，利用SpringMVC的控制器标注
 * @author RanJi
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler{
	
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
    public Map<String,Object> errorHandler(Exception ex) {
        Map<String,Object> map = new HashMap<String,Object>();
        //map.put("code", 100);
        map.put("msg", ex.getMessage());
        return map;
    }
}
