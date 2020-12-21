package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class UserBookServlet extends HttpServlet {
public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
Connection con = null;
Statement stmt = null;
ResultSet rs = null;
int num=0;
res.setContentType("text/html");
PrintWriter out = res.getWriter();
String title=req.getParameter("title");
String location=req.getParameter("location");
String count=req.getParameter("count");
try {
Class.forName("com.mysql.jdbc.Driver");
	// Get a Connection to the database
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
	// Create a Statement object
	stmt = con.createStatement();
	rs=stmt.executeQuery("SELECT * FROM jobs where title='"+title+"' and location ='"+location+"'");
	if(rs.next()){
		num=rs.getInt("number");
		if(num>=Integer.parseInt(count)){
			num = num-Integer.parseInt(count);
			PreparedStatement ps=con.prepareStatement("Update jobs set number=? where title='"+title+"' and location ='"+location+"'");
			ps.setInt(1, num);
			int k=ps.executeUpdate();
			if (k == 1) {
				RequestDispatcher rd = req.getRequestDispatcher("success.html");
				rd.include(req, res);
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("sample.html");
				rd.include(req, res);
				out.println("<h3 class='error'>Sorry for interruption! Try for another Job</h3>");
			}
		}
		else {
				RequestDispatcher rd = req.getRequestDispatcher("sample.html");
				rd.include(req, res);
				out.println("<h3 class='error'>Sorry Job not available</h3>");
			}
	}
	else {
				RequestDispatcher rd = req.getRequestDispatcher("sample.html");
				rd.include(req, res);
				out.println("<h3 class='error'>Sorry for interruption! Try for another Job</h3>");
			}

		}
		 catch(ClassNotFoundException e) {
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
 