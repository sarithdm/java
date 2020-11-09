import java.io.*;
import java.sql.*;
import javax.servlet.*;

import javax.servlet.http.*;

public class FifthServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String number = req.getParameter("number");
		String answer5 = req.getParameter("answer5");
		int mark = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","Lm@200029");
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM exam where Qnumber='"+number+"' and Answer='"+answer5+"'");
			if(rs.next()){
				stmt1 = con.createStatement();
				rs1=stmt1.executeQuery("SELECT score FROM score");
				if(rs1.next()){
					mark=rs1.getInt("score");
				}
				mark = mark+1;
				PreparedStatement ps=con.prepareStatement("Update score set score=? ");
				ps.setInt(1, mark);
				int k=ps.executeUpdate();

			RequestDispatcher rd = req.getRequestDispatcher("exam.html");
			rd.include(req, res);
			out.println("<div class=\"top\">Correct Answer!</div>");
			out.println("<div class=\"top\">Your score is "+mark+"</div>");
			out.println("<div class=\"tab\"><a href=\"View.html\">Submit</a></div>");
			
		}
		else{
			rs1=stmt1.executeQuery("SELECT score FROM score");
				if(rs1.next()){
					mark=rs1.getInt("score");
				}
			RequestDispatcher rd = req.getRequestDispatcher("exam.html");
			rd.include(req, res);
			out.println("<div class=\"top\"> Correct answer is Set</div>");
			out.println("<div class=\"top\">Your score is "+mark+"</div>");
			out.println("<div class=\"tab\"><a href=\"View.html\">Submit</a></div>");
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
