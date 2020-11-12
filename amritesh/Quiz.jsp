<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"  %>
<%@ page import="java.sql.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz Main</title>
<link rel="stylesheet" href="style.css">
<style>
table, th, td {
  border: 1px solid black;
}
table{
	border-collapse: collapse;
}
</style>
</head>
<body>
<center><h1>Quiz</h1></center>
<hr/>
<form class="container" method = "POST" method = "form-group" action = "QuizResults.jsp">
<table cellpadding="2px 50px">
<thead>
<tr>
<th>Question #</th>
<th>Question</th>
<th>Response</th>
<th></th>
</tr>
</thead>
<tbody>
<%
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname?useTimezone=true&serverTimezone=UTC","root","");
Statement statement = connect.createStatement();
ResultSet rSet = statement.executeQuery("select * from ques ;");
while(rSet.next()){
	out.println("<tr>");
	out.println("<td>"+rSet.getInt(1)+"</td>");
	out.println("<td>"+rSet.getString(2)+"</td>");
	out.println("<td> <input type = 'text' name = 'myAnswers' required class = 'form-control'/></td>");
	out.println("<td> <input type = 'hidden' name = 'correctAnswers' value = '"+rSet.getString(3)+"'/></td>");
	out.println("</tr>");
}
}catch(Exception e)
{
	out.println(e);
}
%>
</tbody>
</table>
<button type = "submit" name = "btnSubmit">Submit Answers</button>
</form>
<h3><strong>Note:</strong>Analyse the Answer_options and fill up the Ans_index as your response</h3>
<table>
  <tr>
    <th>Ans_index</th>
    <th>Answers_options</th>
  </tr>
  <tr>
    <td>1.</td>
    <td>Home Tool Markup Language</td>
  </tr>
  <tr>
    <td>2.</td>
    <td>Hyperlinks and Text Markup Languages</td>
  </tr>
  <tr>
    <td>3.</td>
    <td>Hyper Text Markup Language</td>
  </tr>
  <tr>
    <td>4.</td>
    <td>None</td>
  </tr>
  <tr>
    <td>5.</td>
    <td>Maths</td>
  </tr>
  <tr>
    <td>6.</td>
    <td>Os</td>
  </tr>
  <tr>
    <td>7.</td>
    <td>Ds</td>
  </tr>
  <tr>
    <td>8.</td>
    <td>ML</td>
  </tr>
  <tr>
    <td>9.</td>
    <td>In the Header Section</td>
  </tr>
  <tr>
    <td>10.</td>
    <td>In the Body Section</td>
  </tr>
  <tr>
    <td>11.</td>
    <td>Both Head and body</td>
  </tr>
  <tr>
    <td>12.</td>
    <td>None</td>
  </tr>
  <tr>
    <td>13.</td>
    <td>function myfunction</td>
  </tr>
  <tr>
    <td>14.</td>
    <td>function:myfunction</td>
  </tr>
  <tr>
    <td>15.</td>
    <td>function=myfunction</td>
  </tr>
  <tr>
    <td>16.</td>
    <td>None</td>
  </tr>
  <tr>
    <td>17.</td>
    <td>.Container</td>
  </tr>
  <tr>
    <td>18.</td>
    <td>.Container-fixed</td>
  </tr>
  <tr>
    <td>19.</td>
    <td>.Container-fluid</td>
  </tr>
  <tr>
    <td>20.</td>
    <td>None</td>
  </tr>
</table>
</body>
</html>