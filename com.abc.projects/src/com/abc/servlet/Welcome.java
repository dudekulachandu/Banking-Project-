package com.abc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Welcome extends HttpServlet {

	
public void	service(HttpServletRequest req,HttpServletResponse res) throws IOException {

	
	
	
	PrintWriter out=res.getWriter();
	
	out.println("welcome to abc ");
	
	
	
}
	
	
	
	
	
	
	
}
