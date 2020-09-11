import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class dashboard extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Dashboard</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Welcome</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}