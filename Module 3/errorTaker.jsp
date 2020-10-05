<%-- errorTaker.jsp --%>
<%@ page isErrorPage="true" %>
<% response.setStatus(500); %><HTML>
<HTML>
<HEAD><TITLE>Error: <%= exception.getClass().getName() %></TITLE></HEAD>
<BODY>
<H1>
<%= exception.getClass().getName() %>
</H1>
<H2>
</br>
<%= exception.getMessage() %>
</H2>
We encountered an error while executing your page:

<% String name = request.getServerName(); %>
Please contact <A HREF="mailto:webmaster@<%= name %>">webmaster@<%= name %></A>
to report the problem.
</BODY>
</HTML>