package bankingProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validation
 * @param <RequesterDispatch>
 */
@WebServlet("/Validation")
public class Validation<RequesterDispatch> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResourceBundle bundle=null;
	private Connection conn=null;
	private int count=3;
	private PreparedStatement pstmnt=null;
       private Scanner scan=null;
    /**  
     * @see HttpServlet#HttpServlet()
     */
    public Validation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	bundle=ResourceBundle.getBundle("com.abc.utilitie.mysqlinfo");
	
	try {
		
		Scanner scan=new Scanner(System.in);
		
		conn=DriverManager.getConnection(bundle.getString("url"),bundle.getString("name"),bundle.getString("pass"));
	
		
		
		String sql6="insert into Accountt(`AccNo`,`Password`) values(?,?)";
		
		pstmnt=conn.prepareStatement(sql6);
		
String AccNo=req.getParameter("AccoNo");
	
Integer Password=Integer.parseInt(req.getParameter("Password"));
				

pstmnt.setString(1, AccNo);
pstmnt.setInt(2, Password);



int i=pstmnt.executeUpdate();
System.out.println(i);
				
	String AccNo1=AccNo;
	int Password1=Password;
	
	if(AccNo==AccNo1 && Password==Password1)
	{

		RequestDispatcher disp=req.getRequestDispatcher("LoginIndex.html");
		
		disp.include(req , res);
		
	}
	else
	{
	
		if(count>0) {
			
			count--;
			
			
			
			PrintWriter out=res.getWriter();
			
			out.print("Wrong Inputs ");
			
			out.print("only"+count+" Chancess You Have !!!!! ");
			
			
RequestDispatcher disp=req.getRequestDispatcher("LoginFailure.html");
			   disp.include(req, res);
			
			
		}
	}
	
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	finally{
		
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
