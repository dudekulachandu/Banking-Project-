package bankingProject;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.jfr.ContentType;

/**
 * Servlet implementation class Login
 */
@WebServlet("/log")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResourceBundle bundle=null;
	private Connection conn=null;
	private Statement stmnt=null;
	private ResultSet res=null;
	private Scanner scan=null;

	protected void service(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {

		Scanner scan=new Scanner(System.in);
		PrintWriter out=responce.getWriter();
		
		bundle=ResourceBundle.getBundle("com.abc.utilitie.mysqlinfo");
		
		try {
			
			responce.setContentType("text/html");
			//Class.forName("com.mysql.jdbc.Driver");
			
			 Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection(bundle.getString("url"),
			bundle.getString("name"),bundle.getString("pass"));

            
			String sql="select * from transfer";


			stmnt=conn.createStatement();

			res=stmnt.executeQuery(sql);

			while(res.next())
			{

			out.println(res.getString(1)+"\n"+res.getString(2)+"\n"+res.getString(3)+"\n"+res.getDouble(4)+"\n"+res.getInt(5));

			}
			
			
			
			
	RequestDispatcher disp=request.getRequestDispatcher("Showing.html");
	disp.include(request, responce);
			
			
			     
			
			
			
			
			

		} catch (SQLException | ClassNotFoundException  e) {
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

				if(stmnt!=null)
				{
					stmnt.close();
				}
				if(res!=null)
				{
					res.close();
				}
				if(conn!=null) {

					conn.close();

				}
				
				if(scan!=null) {
					
					scan.close();
					
				}
				
			}

		}
