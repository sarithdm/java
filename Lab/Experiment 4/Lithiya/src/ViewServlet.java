import java.io.*;
import java.sql.*;
import javax.servlet.*;

import javax.servlet.http.*;

public class ViewServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","Lm@200029");
			stmt = con.createStatement();
			PreparedStatement ps = con.prepareStatement("Select * from Book");
			ResultSet rs = ps.executeQuery();
			RequestDispatcher rd = req.getRequestDispatcher("View.html");
			rd.include(req, res);
			out.println("<div class=\"tab\">Books Available In Our Store</div>");
			out.println("<div class=\"tab\">\r\n" + 
					"		<table>\r\n" + 
					"			<tr>\r\n" + 
					"				\r\n" + 
					"				<th>Book Name</th>\r\n" + 
					"				<th>Book Code</th>\r\n" + 
					"				<th>Book Author</th>\r\n" + 
					"				<th>Book Price</th>\r\n" + 
					"				<th>Quantity</th><br/>\r\n" + 
					"			</tr>");
			while(rs.next())
			{
				String name = rs.getString(1);
				String barcode = rs.getString(2);
				String author = rs.getString(3);
				int price = rs.getInt(4);
				int quantity = rs.getInt(5);
				out.println("<tr><td>"+name+"</td>");
				out.println("<td>"+barcode+"</td>");
				out.println("<td>"+author+"</td>");
				out.println("<td>"+price+"</td>");
				out.println("<td>"+quantity+"</td></tr>");
			}
			out.println("</table>\r\n" + 
					"	</div>");
			//out.println("<div class=\"tab\"><a href=\"AddBook.html\">Add More Books</a></div>");
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
