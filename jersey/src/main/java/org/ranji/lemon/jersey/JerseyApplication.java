package org.ranji.lemon.jersey;

import org.ranji.lemon.core.CoreApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

public class JerseyApplication extends CoreApplication{
	public static void main(String[] args) {
		SpringApplication.run(JerseyApplication.class, args);  
	}
	
	@Bean
    public TomcatServletWebServerFactory servletContainer(){
        TomcatServletWebServerFactory container = new TomcatServletWebServerFactory() ;
        container.setPort(8090);
        container.setContextPath("/jersey");
        return container;
    }
}
