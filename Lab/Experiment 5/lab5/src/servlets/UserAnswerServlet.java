package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class UserAnswerServlet extends HttpServlet {
public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

res.setContentType("text/html");
PrintWriter out = res.getWriter();

		String q1 = req.getParameter("q1");
		String q2 = req.getParameter("q2");
		String q3 = req.getParameter("q3");
		String q4 = req.getParameter("q4");
		String q5 = req.getParameter("q5");
		int total = 0;
		
		if (q1 == "C") { total++; }
		if (q2 == "A") { total++; }
		if (q3 == "B") { total++; }
		if (q4 == "B") { total++; }
		if (q5 == "B") { total++; }
		
		out.println("<div class=\"tab hd brown\">Exam Successful !</div><br/>");
		out.println("<div class=\"tab hd brown\">" +total+ " / 5 correct</div><br/>");
}
}