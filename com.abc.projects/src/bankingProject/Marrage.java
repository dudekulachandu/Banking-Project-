package bankingProject;

import java.io.IOException;
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
 * Servlet implementation class Marrage
 */
@WebServlet("/Marrage")
public class Marrage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResourceBundle bundle;
	private Connection conn;
	private PreparedStatement pstmnt;
	private Scanner scan=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Marrage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param PanNo 
	 * @param EmiAmount 
	 * @param PhoneNo 
	 * @param city 
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res, int PanNo, String EmiAmount, int PhoneNo, String city) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	
	
	

bundle=ResourceBundle.getBundle("com.abc.utilitie");
	Scanner scan=new Scanner(System.in);
	
	try {
		
		conn=DriverManager.getConnection(bundle.getString("url"),bundle.getString("name"),bundle.getString("pass"));
	
	
	String Sql2="insert into home(`Nmae`,`PanNo`,"
+ "`EmiAmount`,`phoneNo`,`Email`,`Place_to_Stydy`,`city`,`File`, `Income`) values(?,?,?,?,?,?,?)";
	
	
	
	pstmnt=conn.prepareStatement(Sql2);
	
	
	
	String Name=req.getParameter("Name");
	
	Integer AadharNo= Integer.parseInt(req.getParameter("PanNo"));
	
	
	
	Integer PinCode=Integer.parseInt(req.getParameter("EmiAmount"));

	Integer phoneNo=Integer.parseInt(req.getParameter("phoneNo"));
	
	String Email=req.getParameter("Email");

	
	String Place_to_Study=req.getParameter("Place_to_Study");

	String City=req.getParameter("City");

	
	String FatherName=req.getParameter("File");
	
	Integer Income=Integer.parseInt(req.getParameter("Income"));
	
	
	pstmnt.setString(1,Name );
	
	pstmnt.setInt(2, PanNo);
	
	pstmnt.setString(3, EmiAmount);
	
	pstmnt.setInt(4, PhoneNo);
	
	pstmnt.setString(5, Email);
	
	
	pstmnt.setString(7, city);
	
	pstmnt.setInt(9,Income);
	

	
	
	int i=pstmnt.executeUpdate();
	
	System.out.println(i);
	
	
	
	RequestDispatcher dips= req.getRequestDispatcher("MarrageLoan.html");
	
	dips.include(req, res);
	
	
	
	} catch (SQLException e) {
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
	
	
