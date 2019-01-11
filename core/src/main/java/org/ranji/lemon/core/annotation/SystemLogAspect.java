package org.ranji.lemon.core.annotation;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 系统日志：切面处理类
 * @author RanJi
 *
 */
@Aspect
@Component
public class SystemLogAspect {
	
	//-- 定义切点 @Pointcut
	//-- 在注解的位置切入代码
	@Pointcut("@annotation(org.ranji.lemon.core.annotation.SystemLog)")
	public void logPointCut() {}
	
	//-- 切面 配置通知
	@Around("logPointCut()")
	public Object handleSysLog(ProceedingJoinPoint pjp) throws Throwable {
		//-- 1. 调用前do something
		
		//从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
        
		//-- 通过标注获取操作
        SystemLog sysLog = method.getAnnotation(SystemLog.class);
        String op = "";
        if(sysLog != null) {
        	op = sysLog.value();
        }
        //-- 获取访问者的IP
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println("start\tmethod:"+method.getName()+"\topration:"+op+"\tip:"+request.getRemoteAddr());
        
        //-- 2. 调用所加标注的方法(调用该方法后有返回值)
        Object result = pjp.proceed();
        
        //-- 3. 调用后 do something
        System.out.println("end ");
        
        return result;
	}
}
