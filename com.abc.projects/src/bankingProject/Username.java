package bankingProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Username
 */
@WebServlet("/Username")
public class Username extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResourceBundle bundle=null;
	private Connection conn=null;
	private PreparedStatement pstmnt=null;
	private Scanner scan=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Username() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	
	Scanner scan=new Scanner(System.in);
	
		   
				PrintWriter out=res.getWriter();
					
//				String BookName=req.getParameter("BookName");
//				
//				String AuthorName=req.getParameter("AuthorName");
//
//				String Price=req.getParameter("Price");

				
				String AccountNo=req.getParameter("AccountNo");
					
					
				
				
				
					try {
				
				bundle=ResourceBundle.getBundle("com.abc.utilitie.mysqlinfo");
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection(bundle.getString("url"),bundle.getString("user"),bundle.getString("pass"));
			
			
				
				String sq3="select Name from accountt "
						+ "where AccountNo=?";
				
				
				
				
				
				
				
				

				pstmnt=conn.prepareStatement(sq3);
		       
				pstmnt.setString(1, AccountNo);
				
//				pstmnt.setString(2, AuthorName);
//				
//				
//				pstmnt.setString(3, Price);
//				
//				pstmnt.setString(4, ID);
				
			
				
			
				
				
				ResultSet res1=pstmnt.executeQuery();
				
				while(res1.next()) {
					
					out.println(res1.getString(1));
					
					
				}
				
				System.out.println(res1);


				
				
				
				
				
				
		RequestDispatcher disp=req.getRequestDispatcher("updatedsuccessfully.html");
				
				
				disp.forward(req , res);
				
				
				
				
				
				
				
				
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
