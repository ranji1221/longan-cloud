package org.ranji.lemon.facer;

import org.ranji.lemon.core.CoreApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

public class FacerApplication extends CoreApplication{
	public static void main(String[] args) {
		SpringApplication.run(FacerApplication.class, args);  
	}
	
	@Bean
    public TomcatServletWebServerFactory servletContainer(){
        TomcatServletWebServerFactory container = new TomcatServletWebServerFactory() ;
        container.setPort(8080);
        container.setContextPath("/facer");
        return container;
    }
}