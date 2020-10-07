<jsp:useBean id="obj" class="com.it409.Calculator"/>

<%
int m=obj.cube(5);
out.print("cube of 5 is "+m);
%>