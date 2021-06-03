package bankingProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

/**
 * Servlet implementation class RegisterForm
 */
@WebServlet("/RegisterForm")
public class RegisterForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResourceBundle bundle=null;
	private Connection conn=null;
	private PreparedStatement pstmnt=null;
	private Scanner scan=null;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
bundle=ResourceBundle.getBundle("com.abc.utilitie.mysqlinfo");
	Scanner scan=new Scanner(System.in);
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(bundle.getString("url"),bundle.getString("name"),bundle.getString("pass"));
	
	
	String Sql1="insert into Accounttt(`Name`,`AadharNo`,`FatherName`,`phoneNo`,`Email`,`AccountNo`,`Address`,`PinCode`,`AccountType`) values(?,?,?,?,?,?,?,?,?)";
	
	
	
	pstmnt=conn.prepareStatement(Sql1);
	
	
	
	String Name=req.getParameter("Name");
	
	String AadharNo= req.getParameter("AadharNo");
	
	String FatherName=req.getParameter("FatherName");
	
	String PhoneNo=req.getParameter("PhoneNo");
	
	String Email=req.getParameter("Email");
	
	String AccountNo= req.getParameter("AccountNo");
	
	String Address=req.getParameter("Address");
	
    String PinCode=req.getParameter("PinCode");
	
	String AccountType=req.getParameter("AccountType");
	
	
	
	pstmnt.setString(1,Name );
	
	pstmnt.setString(2, AadharNo );
	
	pstmnt.setString(3, FatherName);
	
	pstmnt.setString(4, PhoneNo);
	
	pstmnt.setString(5, Email);
	
	pstmnt.setString(6, AccountNo);
	
	pstmnt.setString(7,Address );
	
	pstmnt.setString(8, PinCode);
	
	pstmnt.setString(9, AccountType);
	
	
	
	int i=pstmnt.executeUpdate();
	
	System.out.println(i);
	
	
	
	
	
	
	
	
	PrintWriter out=res.getWriter();
	
	
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
