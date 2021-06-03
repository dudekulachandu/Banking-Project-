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
 * Servlet implementation class EducationLoa
 */
@WebServlet("/EducationLoa")
public class EducationLoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Scanner scan=null;
	private ResourceBundle bundle=null;
	private Connection conn=null;
	private PreparedStatement pstmnt=null;
	private String city;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EducationLoa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param PanNo 
	 * @param File 
	 * @param EmiAmount 
	 * @param PhoneNo 
	 * @param city 
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	
	
	
	
	


bundle=ResourceBundle.getBundle("com.abc.utilitie.mysqlinfo");
	Scanner scan=new Scanner(System.in);
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(bundle.getString("url"),bundle.getString("name"),bundle.getString("pass"));
	
	
	String Sql2="insert into education(`Name`,`PanNo`,"
+ "`EmiAmount`,`PhoneNo`,`Email`,`StudedCountry`,`city`, `Income`) values(?,?,?,?,?,?,?,?)";
	
	
	
	pstmnt=conn.prepareStatement(Sql2);
	
	
	
	String Name=req.getParameter("Name");
	
	Integer PanNo1= Integer.parseInt(req.getParameter("PanNo"));
	
	
	
	Double EmiAmount1=Double.parseDouble(req.getParameter("EmiAmount"));

	Integer phoneNo=Integer.parseInt(req.getParameter("PhoneNo"));
	
	String Email=req.getParameter("Email");

	
	String StudedCountry=req.getParameter("StudedCountry");

	String city=req.getParameter("city");
	
	Double Income=Double.parseDouble( req.getParameter("Income"));
	
	
	pstmnt.setString(1,Name );
	
	pstmnt.setInt(2, PanNo1);
	
	pstmnt.setDouble(3, EmiAmount1);
	

	pstmnt.setInt(4, phoneNo);
	
	pstmnt.setString(5, Email);
	
	pstmnt.setString(6, StudedCountry);
	

	pstmnt.setString(7, city);
	
	pstmnt.setDouble(8,Income);
	

	
	
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

	
	
	