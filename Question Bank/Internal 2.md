## 1.  What is a directive in JSP? Write the syntax. List any three directives.
* JSP Directives - used to pass instructions to the JSP engine
* A JSP directive allows a JSP page to control certain aspects of its workhorse servlet. Directives can be used to have the workhorse servlet set its content type, import a package, control its output buffering and session management, extend a different superclass, and give special handling to errors.
* A directive can even specify the use of a non-Java scripting language
* The directive syntax requires a directive name along with an attribute name/value pair, all surrounded by <%@ %> tags.
* <%@ directiveName attribName="attribValue" %>
*	Page directives —These directives communicate page-specific information, such as buffer and thread information or error handling.
*	The include directive — This directive can be used to include an external document in the page
*	A taglib directive—This indicates a library of custom tags that the page can invoke.

## 2. Write a JSP program to demonstrate the use of page directive

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

<%-- errorMaker.jsp --%>
<%@ page session="false" %> <%-- Don't send needless cookies --%>
<%@ page errorPage="/errorTaker.jsp" %> <%-- General error handling page --%>
<%-- All we're good for is throwing an exception --%>
<%
if (System.currentTimeMillis() > 0) {
throw new Exception("This is an error message from error maker");
}
%>

## 3.Compare any two application models in JSP with the help of a diagram	

* Basic Architecture:
* In the basic architecture, just like the servlet, the incoming request from a Web browser is sent directly to the JSP page, which is responsible for processing it and replying to the client. 
* There is still separation of presentation from content, because all data access is performed using beans
 

	
* MVC Architecture:
* Model: JavaBeans or EJB—business logic.
* View: JSP—used to compose the user interface.
* Controller: Servlet—used to process the HTTP request and manage the application’s workflow.
 
## 4. How to pass control from one JSP page to another. Explain with the help of an example

Separating presentation pages from request processing/business logic 
more than one page used to process client request 
need to be able to pass control from one page to another 
e.g. in the example, infovalidate.jsp need to be able to forward to either userinput.jsp or confirmed.jsp depending on validation result 
Can use the <jsp:forward> standard action tag 
A validation page (infovalidate.jsp) forward control to a page, userinput.jsp, in order to display an error message. Need to include error message in the forwarding instruction.
<html>
<head>	
<title>User Input JSP File</title>
</head>
<body>
<form action="infovalidate.jsp">
Card Number: <input type ="text" name="cnum">
<br/>
CVV: <input type="text" name="cvv">
<br/>
<input type ="submit" value ="submit">
</form>
</body>
</html><html>
<head>	
<title>User Input JSP File</title>
</head>
<body>
<form action="infovalidate.jsp">
Card Number: <input type ="text" name="cnum">
<br/>
CVV: <input type="text" name="cvv">
<br/>
<input type ="submit" value ="submit">
</form>

<%
out.println("Message - " + request.getParameter("msg"));
out.println("<br/>");

%>

</body>
</html>

<html>
<head>	
<title>Information Validation JSP File</title>
</head>
<body>
<jsp:forward page = "userinput.jsp"> 
<jsp:param name = "msg" value = "invalid credit card number"/> 
</jsp:forward> 

</body>
</html>

## 5. Create a java bean ‘Student’ having attributes name, rollno, age, marks. Write a JSP page    processForm.jsp to display submitted details of students through a form.
<form method="POST" action="processForm.jsp">
Name:    <input name="name"/> </br>
 Username:   <input name="username"/></br>
Job:   <input name="jobTitle"/></br>
   City: <input name="city"/></br>
<input type="submit">

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

## 6. Explain session sharing between JSP page with an example	
There are a number of different techniques available to web applications to enable session tracking, including cookies 
In JSP, it can be done by simply using the ‘scope’ attribute of whatever needs to be tracked. 
Set the ‘scope’ to session, and the relevant attribute will be available throughout the session of the client
Example: a JSP page that displays two counters – a hit counter for the session, and a hit counter for the application
package com.it409;
import java.io.Serializable;

public class Counter implements Serializable{

  // Initialize the bean on creation
  int count = 0;

  // Parameterless Constructor
  public Counter() {

  }

  // Property Getter
  public int getCount() {

    // Increment the count property, with every request
    count++;

    return this.count;
  }

  // Property Setter
  public void setCount(int count) {

    this.count = count;
  }
}

<HTML>
<HEAD>
</HEAD>
<BODY>
<%@ page language="java" %>

<jsp:useBean id="counter" scope="session" class="com.it409.Counter" />

<jsp:setProperty name="counter" property="count" param="count" />
<%

    out.println("Count from scriptlet code : "
      + counter.getCount() + "<BR>");

%>

Count from jsp:getProperty :
  <jsp:getProperty name="counter" property="count" /><BR>

</BODY>
</HTML>
<body>
<jsp:forward page = "userinput.jsp"> 
<jsp:param name = "msg" value = "invalid credit card number"/> 
</jsp:forward> 

</body>
</html>
