package com.abc.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Regist  extends HttpServlet{

private Scanner scan=null;
private  ResourceBundle bundle=null;
private Connection conn =null;
private PreparedStatement pstmnt=null;

public void	service(HttpServletRequest req, HttpServletResponse res)
	
{
	Scanner scan=new Scanner(System.in);
	bundle=ResourceBundle.getBundle("com.abc.utilitie.mysqlinfo");
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn =DriverManager.getConnection(bundle.getString("url"),bundle.getString("name"),bundle.getString("pass"));
			System.out.println("connection is established :");
			
			String sql="insert into First1 (FirstName,LastName,Email,Password)"
					+ "values(?,?,?,?)";
					
			
			
				pstmnt=conn.prepareStatement(sql);
			
			
			
			

				String FirstName=req.getParameter("FirstName");
				
				String LastName=req.getParameter("LastName");
				
				String Email=req.getParameter("Email");
				String Password=req.getParameter("password");
				
				
				
				
				pstmnt.setString(1,FirstName);
			
				pstmnt.setString(2,LastName);
				pstmnt.setString(3,Email);
				pstmnt.setString(4,Password);
			
			int i=pstmnt.executeUpdate();
			System.out.println(i);

			

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
		
	
	
	
	
	
	private void close() throws SQLException {
	// TODO Auto-generated method stub
	
	
	if(scan!=null)
	{
		scan.close();
	}
	
	if(pstmnt!=null)
	{
		pstmnt.close();
	}
	
if(conn!=null)
{
	conn.close();
}
	
	


}	
	
	
}
