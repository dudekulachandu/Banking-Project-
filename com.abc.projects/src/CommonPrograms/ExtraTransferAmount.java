//package CommonPrograms;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class ExtraTransferAmount
// */
//@WebServlet("/ExtraTransferAmount")
//public class ExtraTransferAmount extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ExtraTransferAmount() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	
//	
//
//		 public Account (String AccountNo , double amount, int Pin)
//		    {
//		       this. AccountNo = AccountNo;
//		        this.amount = amount;
//		        balance = initial;
//		    }
//		    public double deposit (double amount)
//		    {
//		        if (amount < 0) // deposit value is negative
//		        {
//		            System.out.println ();
//		            System.out.println ("Error: Deposit amount is invalid.");
//		            System.out.println (AccountNo + " " + fmt.format(amount));
//		        }
//		        else
//		            balance = balance + amount;
//		        return balance;
//		    }
//		
//		
//		    public double withdraw (double amount, double fee)
//		    {
//		        amount += fee;
//		        if (amount < 0) // withdraw value is negative
//		        {
//		        System.out.println ();
//		        System.out.println ("Error: Withdraw amount is invalid.");
//		        System.out.println ("Account: " + acctNumber);
//		        System.out.println ("Requested: " + fmt.format(amount));
//		        }
//		        else
//		        if (amount > balance) // withdraw value exceeds balance
//		        {
//		        System.out.println ();
//		        System.out.println ("Error: Insufficient funds.");
//		        System.out.println ("Account: " + acctNumber);
//		        System.out.println ("Requested: " + fmt.format(amount));
//		        System.out.println ("Available: " + fmt.format(balance));
//		        }
//		        else
//		        balance = balance - amount;
//		        return balance;
//		    }
//
//		
//		
//		
//		    public double transfer (double amount, double fee)
//		    {
//		        amount += fee;
//		        if (amount < 0) // withdraw value is negative
//		        {
//		            System.out.println ();
//		            System.out.println ("Error: Withdraw amount is invalid.");
//		            System.out.println ("Account: " + acctNumber);
//		            System.out.println ("Requested: " + fmt.format(amount));
//		        }
//		        else
//		        if (amount > balance) // withdraw value exceeds balance
//		        {
//		            System.out.println ();
//		            System.out.println ("Error: Insufficient funds.");
//		            System.out.println ("Account: " + acctNumber);
//		            System.out.println ("Requested: " + fmt.format(amount));
//		            System.out.println ("Available: " + fmt.format(balance));
//		        }
//		        else
//		            balance = balance - amount;
//
//	     if (amount < 0) // deposit value is negative
//		        {
//		            System.out.println ();
//		            System.out.println ("Error: Deposit amount is invalid.");
//		            System.out.println (acctNumber + " " + fmt.format(amount));
//		        }
//		        else
//		            balance = balance + amount;
//		    }
//
//		    public double addInterest ()
//		    {
//		        balance += (balance * RATE);
//		        return balance;
//		    }
//		    public double getBalance ()
//		    {
//		        return balance;
//		    }
//		    public long getAccountNumber ()
//		    {
//		        return acctNumber;
//		    }
//		    public String toString ()
//		    {
//		        return (acctNumber + "\t" + name + "\t" + fmt.format(balance));
//		    }
//		}
//
//		
//	
//	
//	
//	
//	
//	}
//
//}
