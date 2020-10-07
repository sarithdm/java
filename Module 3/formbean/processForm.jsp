<%@ page import = "com.it409.Employee"%>
<jsp:useBean id="employee" class="com.it409.Employee">
    <jsp:setProperty name="employee" property="*"/>
</jsp:useBean>
<HTML>
<HEAD><TITLE>Hello</TITLE></HEAD>
<BODY>
<H1>
Name:<jsp:getProperty name="employee" property="name" /> </br>
Username: <jsp:getProperty name="employee" property="username" /></br>
Job: <jsp:getProperty name="employee" property="jobTitle" /></br>
City: <jsp:getProperty name="employee" property="city" /></br>
<%-- name should match getName --%>
</H1>
</BODY>
</HTML>