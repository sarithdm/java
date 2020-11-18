import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class login extends HttpServlet {
public void doPost(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException {

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
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?serverTimezone=UTC","root","kavyak");
// Create a Statement object
stmt = con.createStatement();
// Execute an SQL query, get a ResultSet
rs = stmt.executeQuery("SELECT * FROM USERS where username='"+username+"' and PASSWORD ='"+password+"'");

if(rs.next()){
			RequestDispatcher rd=req.getRequestDispatcher("books.html");
			rd.forward(req,res);
	}
		else{
			out.print("Sorry username or password error");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req,res);
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