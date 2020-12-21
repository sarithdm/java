package servlets;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UserRegisterServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String mailid = req.getParameter("mailid");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
			stmt = con.createStatement();
			PreparedStatement ps = con.prepareStatement("insert into User values(?,?,?,?,?,?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, firstname);
			ps.setString(4, lastname);
			ps.setString(5, address);
			ps.setString(6, phone);
			ps.setString(7, mailid);
			//ps.setInt(8, 2);
			int k = ps.executeUpdate();
			if (k == 1) {
				RequestDispatcher rd = req.getRequestDispatcher("sample.html");
				rd.include(req, res);
				out.println("<h3 class='tab'>User Registered Successfully</h3>");
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("userreg");
				rd.include(req, res);
				out.println("Sorry for interruption! Register again");
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
 