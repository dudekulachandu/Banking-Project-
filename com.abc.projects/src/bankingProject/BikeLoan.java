package bankingProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * Servlet implementation class BikeLoan
 */
@WebServlet("/BikeLoan")
public class BikeLoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResourceBundle bundle=null;
	private Connection conn=null;
	private PreparedStatement pstmnt=null;
    private Scanner scan=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BikeLoan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param PhoneNo 
	 * @param panNo 
	 * @param Bike 
	 * @param EmiPerMonth 
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	
	PrintWriter out=res.getWriter();
	
	

bundle=ResourceBundle.getBundle("com.abc.utilitie.mysqlinfo");
	Scanner scan=new Scanner(System.in);
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(bundle.getString("url"),bundle.getString("name"),bundle.getString("pass"));
	
	
	String Sql1="insert into bikeLoan(`Name`,`PanNo`,`Bike`,"
			+ "`EmiPerMonth`,`phoneNo`,`Email`,`Address`) values(?,?,?,?,?,?,?)";
	
	
	
	pstmnt=conn.prepareStatement(Sql1);
	
	
	
	String Name=req.getParameter("Name");
	
	String PanNo= req.getParameter("PanNo");
	
	String Bike1=req.getParameter("Bike");
	
	String EmiPerMonth1 =req.getParameter("EmiPerMonth");

	String phoneNo=req.getParameter("phoneNo");
	
	String Email=req.getParameter("Email");

	String Address=req.getParameter("Address");

	
	
	
	pstmnt.setString(1,Name );
	
	int panNo = 0;
	pstmnt.setInt(2, panNo);
	
	pstmnt.setString(3, Bike1);
	
	pstmnt.setString(4, EmiPerMonth1);
	
	int PhoneNo = 0;
	pstmnt.setInt(5, PhoneNo);
	
	pstmnt.setString(6, Email);
	
	pstmnt.setString(7,Address );
	

	
	
	int i=pstmnt.executeUpdate();
	
	System.out.println(i);
	
	
	
 RequestDispatcher dips= req.getRequestDispatcher("LoanSuccessful.html");
	
	dips.include(req, res);
	
	
	
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
		
		if(conn!=null)
		{
			conn.close();
		}
		if(pstmnt!=null) {
			pstmnt.close();
		}
	}

	
}


