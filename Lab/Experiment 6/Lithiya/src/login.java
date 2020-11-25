import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class login extends HttpServlet {
public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
Connection con = null;
Statement stmt = null;
ResultSet rs = null;

res.setContentType("text/html");
PrintWriter out = res.getWriter();

String username=req.getParameter("username");
String password=req.getParameter("password");
try {
	// Load (and therefore register) the MySQL Driver
	Class.forName("com.mysql.jdbc.Driver");
	// Get a Connection to the database
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","Lm@200029");
	// Create a Statement object
	stmt = con.createStatement();

	// Execute an SQL query, get a ResultSet
	rs = stmt.executeQuery("SELECT * FROM Users where username='"+username+"' and password ='"+password+"'");
			
	if (rs.next()) {
		RequestDispatcher rd = req.getRequestDispatcher("home.html");
		rd.include(req, res);
		out.println("<div class=\"success\">Welcome ! " + username + "</div><br/>");
		out.println("<div class=\"success\">User Login Successful !</div><br/>");
			} else {

				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.include(req, res);
				out.println("<div class=\"error\">Incorrect UserName or PassWord</div>");
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
