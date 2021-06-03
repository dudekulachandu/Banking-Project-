package com.abc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		 PrintWriter out=res.getWriter();
		
		out.println("username is:"+username);
		
		out.println("password"+password);
		
		String username1="chandu";
		String password1="chandu89@";
		
		if(username1.equalsIgnoreCase(username)
				&& password1.equals(password))
		{res.setContentType("text.html");
			RequestDispatcher dispatcher=req.getRequestDispatcher(password1);
		dispatcher.forward(req, res);
		}
		else {		
			for(int i=0;i<=3;i--)
			{
				
				out.println(i+"only you have try it !!!");
				
				RequestDispatcher dispatcher=req.getRequestDispatcher("head.html");
				dispatcher.include(req, res);
				
				
			}
			RequestDispatcher dispatcher=req.getRequestDispatcher("blocked.html");
		dispatcher.forward(req, res);
		
		
		}
		
		
		
		
	}

}
