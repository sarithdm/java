import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class updateServlet extends HttpServlet {
public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
Connection con = null;
Statement stmt = null;
ResultSet rs = null;
int quant=0;
res.setContentType("text/html");
PrintWriter out = res.getWriter();
String barcode=req.getParameter("barcode");
try {
	// Load (and therefore register) the MySQL Driver
	Class.forName("com.mysql.jdbc.Driver");
	// Get a Connection to the database
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","Lm@200029");
	// Create a Statement object
	stmt = con.createStatement();
	rs=stmt.executeQuery("Select quantity from book where barcode='"+barcode+"'");
	if(rs.next()){
		quant=rs.getInt("quantity");
	}
	quant = quant-1;
	PreparedStatement ps=con.prepareStatement("Update book set quantity=? where barcode ='"+barcode+"'");
	ps.setInt(1, quant);
	int k=ps.executeUpdate();
	if (k == 1) {
				RequestDispatcher rd = req.getRequestDispatcher("payment.html");
				rd.include(req, res);
				out.println("<h3 class='tab'>Thank you!</h3>");
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("Buy.html");
				rd.include(req, res);
				out.println("Sorry for interruption! Try again");
			}
		} catch(ClassNotFoundException e) {
		out.println("Couldn't load database driver: " + e.getMessage());
		}
		catch(SQLException e) {
		out.println("SQLException caught: " + e.getMessage());
		}
		finally {
		// Always close the database connection.
		try {
		if (con != null) con.close();
		}
catch (SQLException ignored) { }
}
}
}

