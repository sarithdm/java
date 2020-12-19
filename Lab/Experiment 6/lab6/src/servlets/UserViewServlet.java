package servlets;

import java.io.*;
import java.sql.*;
import javax.servlet.*;

import javax.servlet.http.*;

public class UserViewServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
			stmt = con.createStatement();
			PreparedStatement ps = con.prepareStatement("Select * from train");
			rs = ps.executeQuery();
			RequestDispatcher rd = req.getRequestDispatcher("view.html");
			rd.include(req, res);
			out.println("<div class=\"success\">View our schedule</div>");
			out.println("<div class=\"success\">\r\n" + 
					"		<table>\r\n" + 
					"			<tr>\r\n" + 
					"				\r\n" + 
					"				<th>Bus Number</th>\r\n" + 
					"				<th>Source</th>\r\n" + 
					"				<th>Destination</th>\r\n" + 
					"				<th>Month</th>\r\n" +  
					"				<th>Day</th>\r\n" + 
					"				<th>Seats Available</th><br/>\r\n" + 
					"			</tr>");
			while(rs.next())
			{
				String bnumber = rs.getString(1);
				String source = rs.getString(2);
				String destination = rs.getString(3);
				String month = rs.getString(4);
				int date = rs.getInt(5);
				int seats = rs.getInt(6);
				out.println("<tr><td>"+bnumber+"</td>");
				out.println("<td>"+source+"</td>");
				out.println("<td>"+destination+"</td>");
				out.println("<td>"+month+"</td>");
				out.println("<td>"+date+"</td>");
				out.println("<td>"+seats+"</td></tr>");
			}
			out.println("</table>\r\n" + 
					"	</div>");
			
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