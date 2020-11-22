import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class exam extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String username = req.getParameter("username");
		String answer = req.getParameter("answer");
		String answer1= req.getParameter("answer1");
		String answer2= req.getParameter("answer2");
		String answer3 = req.getParameter("answer3");
		String answer4 = req.getParameter("answer4");
		try {
		Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?serverTimezone=UTC","root","kavyak");
			stmt = con.createStatement();
			PreparedStatement ps = con
					.prepareStatement("insert into exam values(?,?,?,?,?,?)");
			ps.setString(1,username);
			ps.setString(2, answer);
			ps.setString(3, answer1);
			ps.setString(4, answer2);
			ps.setString(5, answer3);
			ps.setString(6, answer4);
			//ps.setInt(8, 2);
			int k = ps.executeUpdate();
			if (k == 1) {
				RequestDispatcher rd = req.getRequestDispatcher("success.html");
				rd.include(req, res);
				out.println("<h3 class='tab'>Examination completed</h3>");
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("exam");
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
