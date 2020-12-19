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
int seat=0;
res.setContentType("text/html");
PrintWriter out = res.getWriter();
String source=req.getParameter("source");
String destination=req.getParameter("destination");
String month=req.getParameter("month");
String date=req.getParameter("date");
String count=req.getParameter("count");
try {
Class.forName("com.mysql.jdbc.Driver");
	// Get a Connection to the database
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
	// Create a Statement object
	stmt = con.createStatement();
	rs=stmt.executeQuery("SELECT * FROM train where source='"+source+"' and destination ='"+destination+"' and month='"+month+"' and date='"+date+"'");
	if(rs.next()){
		seat=rs.getInt("seats");
		if(seat>=Integer.parseInt(count)){
			seat = seat-Integer.parseInt(count);
			PreparedStatement ps=con.prepareStatement("Update train set seats=? where source='"+source+"' and destination ='"+destination+"' and month='"+month+"' and date='"+date+"'");
			ps.setInt(1, seat);
			int k=ps.executeUpdate();
			if (k == 1) {
				RequestDispatcher rd = req.getRequestDispatcher("success.html");
				rd.include(req, res);
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("sample.html");
				rd.include(req, res);
				out.println("<h3 class='error'>Sorry for interruption! Try for another date</h3>");
			}
		}
		else {
				RequestDispatcher rd = req.getRequestDispatcher("sample.html");
				rd.include(req, res);
				out.println("<h3 class='error'>Sorry Seats not available</h3>");
			}
	}
	else {
				RequestDispatcher rd = req.getRequestDispatcher("sample.html");
				rd.include(req, res);
				out.println("<h3 class='error'>Sorry for interruption! Try for another date</h3>");
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