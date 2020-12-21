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
			PreparedStatement ps = con.prepareStatement("Select * from jobs");
			rs = ps.executeQuery();
			RequestDispatcher rd = req.getRequestDispatcher("view.html");
			rd.include(req, res);
			out.println("<div class=\"success\">View our Jobs</div>");
			out.println("<div class=\"success\">\r\n" + 
					"		<table>\r\n" + 
					"			<tr>\r\n" + 
					"				\r\n" + 
					"				<th>Job Number</th>\r\n" + 
					"				<th>Title</th>\r\n" + 
					"				<th>Location</th>\r\n" +  
					"				<th>Vacancies Available</th><br/>\r\n" + 
					"			</tr>");
			while(rs.next())
			{
				String bnumber = rs.getString(1);
				String title = rs.getString(2);
				String location = rs.getString(3);
				int num = rs.getInt(4);
				out.println("<tr><td>"+bnumber+"</td>");
				out.println("<td>"+title+"</td>");
				out.println("<td>"+location+"</td>");
				out.println("<td>"+num+"</td></tr>");
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
 