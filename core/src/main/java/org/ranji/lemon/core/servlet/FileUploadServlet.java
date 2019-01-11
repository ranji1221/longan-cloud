package org.ranji.lemon.core.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="",urlPatterns= {"/test"})
@MultipartConfig(location="/tmp",
				maxFileSize=5242880,       //-- 5M
				maxRequestSize=20971520 )  //-- 20M
public class FileUploadServlet extends HttpServlet{
	private static final long serialVersionUID = -8981076846137300495L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	        //handle file upload  
		
	}        

}
