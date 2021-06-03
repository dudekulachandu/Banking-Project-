package bankingProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
	private ResourceBundle bundle=null;
	private Connection conn=null;
	private Scanner scan=null;
	private Statement stmnt=null;
	private ResultSet res1=null;
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	String accnum=req.getParameter("AccountNo");
	String amt=req.getParameter("amount");
	double amtt=Double.parseDouble(amt);
	String pinn=req.getParameter("Pinn");
	int checkpin = Integer.parseInt(pinn);

	System.out.println(checkpin);
	System.out.println(accnum);
	System.out.println(amt);

			
			
		bundle=ResourceBundle.getBundle("com.abc.utilitie.mysqlinfo");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(bundle.getString("url"),bundle.getString("name"),bundle.getString("pass"));



			//			String sql8="update  transfer set Pin=?"
			//					+ " amount=?"
			//					+ " where AccountNo=?";

			//String sql6="update into transfer(`AccountNo`,`amount`,`Pin`,) values(?,?,?)";

			String acc=null;
			int pin=0;
			double amount=0;


			String sql8="select * from transfer";


			stmnt=conn.createStatement();


			res1=stmnt.executeQuery(sql8);
			
			while(res1.next())
			{
				
		     acc = res1.getString(3);
		     amount=res1.getDouble(4);
			pin =res1.getInt(5);
			}

			
			System.out.println(acc);
			System.out.println(amount);
			System.out.println(pin);


			if(acc.equals(accnum) && pin==checkpin)

			{

				


				if(amtt>amount) {

					System.out.println("sorry Dear your ins");

				}
				
			else if(amtt<amount){

					double withdraw=amount-amtt;

		System.out.println("the withdraw amount is "+withdraw);
				}
			}
			else {
				System.out.println("jhghgch");
			}

		
		
		
		
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
			if(stmnt!=null) {
				stmnt.close();
			}
		}

	}	

	
			
			
			
			//		}



			//			pstmnt=conn.prepareStatement(sql8);
			//
			//			String AccountNo=req.getParameter("AccountNo");
			//
			//			double amount=Double.parseDouble(req.getParameter("amount"));
			//
			//			Integer Pin=Integer.parseInt(req.getParameter("Pin"));



			//			pstmnt.setString(1, AccountNo);
			//			pstmnt.setDouble(2, amount);
			//			pstmnt.setInt(3, Pin);







			//			if(AccountNo==AccountNo && pin==pin)
			//			{
			//
			//				RequestDispatcher disp=req.getRequestDispatcher("index.html");
			//
			//				disp.include(req, res);
			//
			//			}
			//
			//			else {
			//
			//				out.println("you have entered Wrong details Dear!!!!! ");
			//
			//				RequestDispatcher dispat=req.getRequestDispatcher("WrongCredentioals.html");
			//
			//				dispat.forward(req, res);
			//
			//			}







