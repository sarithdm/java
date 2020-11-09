package servlets;
import java.io.*;
import java.sql.*;
import javax.servlet.*;

import javax.servlet.http.*;

public class ViewBookServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		Connection con = null;
		Statement stmt = null;
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
			stmt = con.createStatement();
			PreparedStatement ps = con.prepareStatement("Select * from Book");
			ResultSet rs = ps.executeQuery();
			RequestDispatcher rd = req.getRequestDispatcher("ViewBooks.html");
			rd.include(req, res);
			out.println("<div class=\"tab\">Books Available In Our Store</div>");
			out.println("<div class=\"tab\">\r\n" + 
					"		<table>\r\n" + 
					"			<tr>\r\n" + 
					"				\r\n" + 
					"				<th>Book Code</th>\r\n" + 
					"				<th>Book Name</th>\r\n" + 
					"				<th>Book Author</th>\r\n" + 
					"				<th>Book Price</th>\r\n" + 
					"				<th>Quantity</th><br/>\r\n" + 
					"			</tr>");
			while(rs.next())
			{
				String bCode = rs.getString(1);
				String bName = rs.getString(2);
				String bAuthor = rs.getString(3);
				int bPrice = rs.getInt(4);
				int bQty = rs.getInt(5);
				out.println("<tr><td>"+bCode+"</td>");
				out.println("<td>"+bName+"</td>");
				out.println("<td>"+bAuthor+"</td>");
				out.println("<td>"+bPrice+"</td>");
				out.println("<td>"+bQty+"</td></tr>");
			}
			out.println("</table>\r\n" + 
					"	</div>");
			//pw.println("<div class=\"tab\"><a href=\"AddBook.html\">Add More Books</a></div>");
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