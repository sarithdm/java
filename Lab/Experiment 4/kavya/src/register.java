import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class register extends HttpServlet {
public void doPost(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException {

Connection con = null;
Statement stmt = null;
ResultSet rs = null;
res.setContentType("text/html");
PrintWriter out = res.getWriter();
String username = req.getParameter("username");
String password = req.getParameter("password");
String email= req.getParameter("email");
try {
// Load (and therefore register) the MySQL Driver
Class.forName("com.mysql.jdbc.Driver");
// Get a Connection to the database
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?serverTimezone=UTC","root","kavyak");
// Create a Statement object
stmt = con.createStatement();
PreparedStatement ps = con
					.prepareStatement("insert into Users values(?,?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3,email);
int k = ps.executeUpdate();
			if (k == 1) {
				RequestDispatcher rd = req.getRequestDispatcher("log.html");
				rd.include(req, res);
				out.println("<h3>Registration Successful</h3>");
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("signup.html");
				rd.include(req, res);
				out.println("Sorry try again");
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
			
			