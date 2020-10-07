<%-- hello3.jsp --%>
<%@ page import="com.it409.HelloBean" %>
<jsp:useBean id="objhello" class="com.it409.HelloBean" />
<HTML>
<HEAD><TITLE>Hello</TITLE></HEAD>
<BODY>
<H1>
Hello, <jsp:getProperty name="objhello" property="name" />
<%-- name should match getName --%>
</H1>
</BODY>
</HTML>